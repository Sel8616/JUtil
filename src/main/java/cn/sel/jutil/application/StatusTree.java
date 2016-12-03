/*
 * Copyright 2015-2016 Erlu Shang (sel8616@gmail.com/philshang@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.sel.jutil.application;

import cn.sel.jutil.annotation.note.NonNull;
import cn.sel.jutil.annotation.note.Nullable;
import cn.sel.jutil.lang.JText;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StatusTree
{
    private static final Pattern PATTERN_DOT = Pattern.compile("\\.");
    private final String name;
    private final boolean caseSensitive;
    private final CascadeStrategy cascadeStrategy;
    private final Node root;

    /**
     * @param caseSensitive
     * @param cascadeStrategy Defaults to {@link CascadeStrategy#DOWN}.
     */
    public StatusTree(String name, boolean caseSensitive, @NonNull CascadeStrategy cascadeStrategy)
    {
        Objects.requireNonNull(cascadeStrategy);
        this.name = name;
        this.cascadeStrategy = cascadeStrategy;
        this.caseSensitive = caseSensitive;
        root = new Node(name, caseSensitive, cascadeStrategy);
    }

    public StatusTree()
    {
        this(null, true, CascadeStrategy.DOWN);
    }

    @Nullable
    public static StatusTree merge(String newName, StatusTree... trees)
            throws IllegalStateException
    {
        if(trees.length < 1)
        {
            return null;
        }
        StatusTree first = trees[0];
        StatusTree result = new StatusTree(newName, first.caseSensitive, first.cascadeStrategy);
        for(StatusTree tree : trees)
        {
            Node root = tree.root;
            List<String> allNodeNames = tree.allNodeNames();
            Set<String> statusNames = root.getStatuses().keySet();
            for(String nodeName : allNodeNames)
            {
                for(String statusName : statusNames)
                {
                    Boolean savedStatus = result.getStatus(nodeName, statusName);
                    Boolean currentStatus = tree.getStatus(nodeName, statusName);
                    boolean newStatus = savedStatus != null && savedStatus || currentStatus != null && currentStatus;
                    boolean success = result.setStatus(nodeName, statusName, newStatus);
                    if(!success)
                    {
                        throw new IllegalStateException(String.format("Failed to set status of node '%s'.", nodeName));
                    }
                }
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        return "StatusTree{" + "name='" + name + '\'' + ", caseSensitive=" + caseSensitive + ", cascadeStrategy=" + cascadeStrategy + ", root=" + root + '}';
    }

    public String getName()
    {
        return name;
    }

    public boolean isCaseSensitive()
    {
        return caseSensitive;
    }

    @NonNull
    public CascadeStrategy getCascadeStrategy()
    {
        return cascadeStrategy;
    }

    @Nullable
    public Boolean getStatus(String fullPath)
    {
        if(root.size() > 0)
        {
            String[] array = split(fullPath);
            return getStatus(array[0], array[1]);
        }
        return null;
    }

    @Nullable
    public Boolean getStatus(String nodePath, String statusName)
    {
        Node node = getNode(nodePath);
        return node == null ? null : node.getStatus(statusName);
    }

    public boolean setStatus(String fullPath, boolean value)
    {
        if(JText.isNormal(fullPath))
        {
            String[] array = split(fullPath);
            return setStatus(array[0], array[1], value);
        }
        return false;
    }

    public boolean setStatus(String nodePath, String statusName, boolean value)
    {
        Node node = getNode(nodePath);
        if(node == null)
        {
            node = newNode(nodePath);
        }
        if(node == null)
        {
            return false;
        }
        String actualStatusName = node.getActualMapKey(node.statuses.keySet(), statusName);
        if(JText.isNormal(actualStatusName))
        {
            if(node.setStatus(actualStatusName, value))
            {
                return node.getStatus(statusName) == value;
            }
        }
        return false;
    }

    public void match(@NonNull StatusTree criterion)
            throws NullPointerException, IllegalStateException
    {
        Objects.requireNonNull(criterion);
        List<String> errs = new ArrayList<>();
        List<String> allNodeNames = criterion.allNodeNames();
        errs.addAll(allNodeNames.stream().filter(nodeName->!has(nodeName)).collect(Collectors.toList()));
        if(!errs.isEmpty())
        {
            throw new IllegalStateException(String.format("Mismatches: %s.", errs));
        }
    }

    public List<String> allNodeNames()
    {
        LinkedList<String> allNameNames = new LinkedList<>();
        collectAllNodeNames(allNameNames, root, null);
        return allNameNames;
    }

    private Node getNode(String path)
    {
        if(JText.isNullOrEmpty(path))
        {
            return root;
        }
        LinkedList<String> linkedPath = new LinkedList<>();
        String[] split = PATTERN_DOT.split(path);
        Collections.addAll(linkedPath, split);
        return find(root, linkedPath);
    }

    /**
     * Create a new {@link Node} with the specified name, and add it into the specified parent.
     */
    private Node newNode(String nodePath)
    {
        String[] nodeNames = PATTERN_DOT.split(nodePath);
        int count = nodeNames.length;
        if(count > 0)
        {
            Node parent = root;
            String firstName = nodeNames[0];
            Node node = getNode(firstName);
            if(node == null)
            {
                node = new Node(firstName, caseSensitive, cascadeStrategy);
            }
            parent.addChild(node);
            if(count > 1)
            {
                String parentPath = "";
                for(int i = 1; i < count; i++)
                {
                    String parentName = nodeNames[i - 1];
                    parentPath = parentPath.isEmpty() ? parentName : parentPath + '.' + parentName;
                    parent = getNode(parentName);
                    if(parent == null)
                    {
                        parent = new Node(parentName, caseSensitive, cascadeStrategy);
                    }
                    String nodeName = nodeNames[i];
                    node = getNode(parentPath + '.' + nodeName);
                    if(node == null)
                    {
                        node = new Node(nodeName, caseSensitive, cascadeStrategy);
                    }
                    parent.addChild(node);
                }
            }
            return node;
        } else
        {
            return null;
        }
    }

    private boolean has(String nodeName)
    {
        return getNode(nodeName) != null;
    }

    private void collectAllNodeNames(List<String> list, Node statusTreeNode, String curNodeName)
    {
        assert list != null;
        boolean isRoot = curNodeName == null;
        list.add(isRoot ? null : curNodeName);
        Map<String, Node> children = statusTreeNode.getChildren();
        if(!children.isEmpty())
        {
            for(Node childStatusTreeNode : children.values())
            {
                String childNodeName = childStatusTreeNode.name;
                String nextNodeName = isRoot ? childNodeName : curNodeName + '.' + childNodeName;
                collectAllNodeNames(list, statusTreeNode.getChild(childNodeName), nextNodeName);
            }
        }
    }

    private Node find(Node node, LinkedList<String> linkedPath)
    {
        while(true)
        {
            if(linkedPath.isEmpty())
            {
                return node;
            } else
            {
                String head = linkedPath.removeFirst();
                Node child = node.getChild(head);
                if(child != null)
                {
                    node = child;
                } else if(head.equals(node.name))
                {
                    return node;
                } else
                {
                    return null;
                }
            }
        }
    }

    private String[] split(String path)
    {
        String[] result = new String[2];
        int index = path.lastIndexOf('.');
        result[0] = path.substring(0, index < 0 ? index + 1 : index);
        result[1] = path.substring(index + 1);
        return result;
    }

    public enum CascadeStrategy
    {
        UP,
        DOWN
    }

    private static class Node
    {
        private final String name;
        private final boolean caseSensitive;
        private final CascadeStrategy cascadeStrategy;
        private final Map<String, Boolean> statuses = new HashMap<>();
        private final Map<String, Node> children = new HashMap<>();
        private Node parent;

        /**
         * @param name            The name of the node. The node will be forced to a root if null is passed.
         * @param caseSensitive
         * @param cascadeStrategy
         */
        public Node(@Nullable String name, boolean caseSensitive, CascadeStrategy cascadeStrategy)
        {
            this.name = name;
            this.caseSensitive = caseSensitive;
            this.cascadeStrategy = cascadeStrategy;
        }

        public Node()
        {
            name = null;
            cascadeStrategy = CascadeStrategy.DOWN;
            caseSensitive = false;
        }

        @NonNull
        public String getName()
        {
            return name;
        }

        @NonNull
        public Map<String, Boolean> getStatuses()
        {
            return statuses;
        }

        public Boolean getStatus(String statusName)
        {
            String name = getActualMapKey(statuses.keySet(), statusName);
            return statuses.get(name);
        }

        public boolean setStatus(String statusName, boolean value)
        {
            String name = getActualMapKey(statuses.keySet(), statusName);
            if(JText.isNormal(name))
            {
                statuses.put(name, value);
                switch(cascadeStrategy)
                {
                    case UP:
                        if(parent != null)
                        {
                            parent.setStatus(statusName, value);
                        }
                        break;
                    case DOWN:
                        children.values().stream().filter(Objects::nonNull).forEach(child->child.setStatus(statusName, value));
                        break;
                }
                return true;
            }
            return false;
        }

        @NonNull
        public Map<String, Node> getChildren()
        {
            return children;
        }

        public Node getChild(String childName)
        {
            String name = getActualMapKey(children.keySet(), childName);
            return children.get(name);
        }

        public boolean addChild(Node child)
        {
            if(child != null)
            {
                String childName = child.name;
                if(JText.isNormal(childName))
                {
                    children.put(childName, child);
                    if(child.getParent() == null)
                    {
                        child.setParent(this);
                    }
                    return true;
                }
            }
            return false;
        }

        public void removeChild(String childName)
        {
            String name = getActualMapKey(children.keySet(), childName);
            Node child = getChild(name);
            if(child != null)
            {
                child.setParent(null);
            }
            children.remove(name);
        }

        public Node getParent()
        {
            return parent;
        }

        public void setParent(Node parent)
        {
            if(this.parent != null)
            {
                this.parent.removeChild(name);
            }
            this.parent = parent;
            if(parent != null)
            {
                parent.addChild(this);
            }
        }

        public int size()
        {
            return children.size();
        }

        private String getActualMapKey(Set<String> keySet, String key)
        {
            if(caseSensitive)
            {
                return key;
            }
            for(String k : keySet)
            {
                if(k.equalsIgnoreCase(key))
                {
                    return k;
                }
            }
            return null;
        }

        @Override
        public String toString()
        {
            return "Node{" + "name='" + name + '\'' + ", statuses=" + statuses + ", children=" + children + '}';
        }
    }
}