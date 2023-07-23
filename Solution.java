import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class Solution {
  static Map<Integer, List<TreeNode>> saved = new HashMap<>();

  public List<TreeNode> allpossibleFBT(int n){
    if(n%2==0)
        return new ArrayList<>();

        if(!saved.containsKey(n)){
            List<TreeNode> list = new ArrayList<>();

            if(n==1)
            list.add(new TreeNode(0));
            else{
                for(int i=1; i<=n-1; i+=2){
                    List<TreeNode> lTrees = allpossibleFBT(i);
                    List<TreeNode> rTrees = allpossibleFBT(n-i-1);
                    
                    for(TreeNode lt:lTrees){
                        for(TreeNode rt:rTrees){
                            list.add(new TreeNode(0, lt, rt));
                        }
                    }
                }
            }
            saved.put(n, list);
        }
        return saved.get(n);
}
}
