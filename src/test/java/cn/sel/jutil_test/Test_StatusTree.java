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
package cn.sel.jutil_test;

import cn.sel.jutil.application.StatusTree;
import org.junit.Test;

public class Test_StatusTree
{
    private static final String READABLE = "READABLE";
    private static final String WRITABLE = "WRITABLE";

    @Test
    public void test()
            throws Exception
    {
        System.out.println("Create a tree named 'tree1");
        StatusTree tree1 = new StatusTree("computer", true, StatusTree.CascadeStrategy.UP);
        System.out.println(tree1);
        System.out.println();
        //
        setStatus(tree1, null, READABLE, true);
        setStatus(tree1, "C.Windows", READABLE, true);//Check cascade
        setStatus(tree1, "C.Programs", READABLE, true);
        setStatus(tree1, "C", READABLE, true);
        setStatus(tree1, "D", READABLE, true);
        //
        //
        System.out.println();
        StatusTree tree2 = new StatusTree("computer", true, StatusTree.CascadeStrategy.DOWN);
        System.out.println("Another tree.");
        System.out.println(tree2);
        //
        setStatus(tree2, null, WRITABLE, true);
        setStatus(tree2, "C.Windows", WRITABLE, true);
        setStatus(tree2, "C.Programs", WRITABLE, true);
        setStatus(tree2, "C", WRITABLE, true);
        setStatus(tree2, "D", WRITABLE, true);
        setStatus(tree2, "D.Downloads", WRITABLE, true);
        setStatus(tree2, "D", WRITABLE, false);//Check cascade
        setStatus(tree2, "D", WRITABLE, true);
        setStatus(tree2, "E", WRITABLE, true);
        //
        System.out.println();
        System.out.println("Merge the 2 trees.");
        StatusTree merge = StatusTree.merge("merged", tree1, tree2);
        System.out.println("First  Tree: " + tree1);
        System.out.println("Second Tree: " + tree2);
        System.out.println("Merged Tree: " + merge);
        assert merge != null;
        //
        Boolean status;
        status = merge.getStatus(null, READABLE);
        assert status != null && status;
        status = merge.getStatus(null, WRITABLE);
        assert status != null && status;
        status = merge.getStatus("C", READABLE);
        assert status != null && status;
        status = merge.getStatus("C", WRITABLE);
        assert status != null && status;
        status = merge.getStatus("C.Windows", READABLE);
        assert status != null && status;
        status = merge.getStatus("C.Windows", WRITABLE);
        assert status != null && status;
        status = merge.getStatus("C.Programs", READABLE);
        assert status != null && status;
        status = merge.getStatus("C.Programs", WRITABLE);
        assert status != null && status;
        status = merge.getStatus("D", READABLE);
        assert status != null && status;
        status = merge.getStatus("D", WRITABLE);
        assert status != null && status;
    }

    private void setStatus(StatusTree StatusTree, String path, String key, boolean enabled)
    {
        boolean success;
        System.out.println();
        System.out.print(String.format("Set Status -> %s    %s", key, enabled ? "ON" : "OFF"));
        success = StatusTree.setStatus(path, key, enabled);
        System.out.println(String.format("    %s    %s", success ? "SUCCESS" : "FAILURE", path));
        System.out.println(StatusTree);
        assert success;
        Boolean status = StatusTree.getStatus(path, key);
        assert status != null && enabled == status;
    }
}