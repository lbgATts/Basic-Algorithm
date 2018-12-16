package com;

import java.util.Stack;

public class TreeVistNotRecur {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        char value;
        public TreeNode(char value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public TreeNode(char value, TreeNode left, TreeNode right){
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //根据递归的过程来想，它每遇到一个节点，就以之为根节点，不断向左下放遍历，入栈，直到空
    //然后栈弹出，又以弹出点右孩子为根（非空的），继续刚才左下滑的过程
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode tmp = root;
        while (!stk.empty() || tmp != null) {
            while (tmp != null) {
                System.out.println("--->:" + tmp.value);
                stk.push(tmp);//找到一个节点，然后一直找到最底下的左节点
                tmp = tmp.left;//退出的时候 tmp 是空的
            }
            //左子树找完
            if (!stk.empty()) {
                tmp = stk.pop();
                tmp = tmp.right;//这里tmp 可能是空的，为什么？
            }
        }
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stk = new Stack();
        TreeNode tmp = root;
        while (!stk.empty() || tmp != null) {
            while (tmp != null) {
                stk.push(tmp);//找到一个节点，然后一直找到最底下的左节点
                tmp = tmp.left;//退出的时候 tmp 是空的，但是栈中是没有null值的
            }
            //左子树找完，然后找右子树
            if (!stk.empty()) {
                tmp = stk.pop();
                System.out.println("--->:" + tmp.value);
                tmp = tmp.right;//这里tmp 可能是空的，为什么？
            }
        }
    }


    /*(可结合后序遍历结果进行分析)
     * 与前序遍历相反，后序遍历相当于每次从根节点开始，一直向右下方向搜寻直到空，逐个入栈，遇到null后，
     * 依次出栈，让出栈点的左孩子执行相同的操作（需要一个辅助栈保存）；最后将栈的元素一起弹出
     * 因此：后序遍历需要用两个栈
     * */
    public static void postOrder(TreeNode root) {
        TreeNode temp=root;
        Stack<TreeNode> stack=new Stack();
        Stack<TreeNode> stackHelp=new Stack();
        while(temp!=null || !stack.isEmpty()){
            while(temp!=null){
                stack.push(temp);
                stackHelp.push(temp);//此句是唯一与前序遍历不同的地方（进入辅助栈）  
                temp=temp.right;
            }
            if(!stack.isEmpty()){
                temp=stack.pop();
                temp=temp.left;
            }
        }
        while(!stackHelp.isEmpty()){
            temp=stackHelp.pop();
            System.out.print("-->" + temp.value);
        }
    }


    //不明白的大家可以一起讨论！欢迎留言！

    /**
     * public class Node {
     public int data; //树结点标号
     public Node lchild; //左子树
     public Node rchild;  //右子树
     }
     后序遍历递归定义：先左子树，后右子树，再根节点。
     后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
     若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
     若是位于右子树，则直接访问根节点。
     */
    //这是最正确的版本，也最好理解
    public static void postOrder2(TreeNode node){
        if(node==null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();

        TreeNode curNode; //当前访问的结点
        TreeNode lastVisitNode; //上次访问的结点
        curNode = node;
        lastVisitNode = null;

        //把currentNode移到左子树的最下边
        while(curNode!=null){
            s.push(curNode);
            curNode = curNode.left;
        }
        while(!s.empty()){
            curNode = s.pop();  //弹出栈顶元素
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if(curNode.right!=null && curNode.right!=lastVisitNode){
                //根节点再次入栈
                s.push(curNode);
                //进入右子树，且可肯定右子树一定不为空
                curNode = curNode.right;
                while(curNode!=null){
                    //再走到右子树的最左边
                    s.push(curNode);
                    curNode = curNode.left;
                }
            }else{
                //访问
                System.out.print(curNode.value + ",");
                //修改最近被访问的节点
                lastVisitNode = curNode;
            }
        } //while
    }



    //后序遍历
    /**后序遍历递归定义：先左子树，后右子树，再根节点。
     * 后序遍历的难点在于：需要判断上次访问的节点是位于左子树，还是右子树。
     * 若是位于左子树，则需跳过根节点，先进入右子树，再回头访问根节点；
     * 若是位于右子树，则直接访问根节点。
     */
    static void PostOrderWithoutRecursion(TreeNode root)
    {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack();
        //pCur:当前访问节点，pLastVisit:上次访问节点
        TreeNode pCur, pLastVisit;
        //pCur = root;
        pCur = root;
        pLastVisit = null;
        //先把pCur移动到左子树最下边
        while (pCur != null)
        {
            s.push(pCur);
            pCur = pCur.left;
        }
        while (!s.empty())
        {
            //走到这里，pCur都是空，并已经遍历到左子树底端(看成扩充二叉树，则空，亦是某棵树的左孩子)
            pCur = s.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (pCur.right == null || pCur.right == pLastVisit)
            {
                System.out.print(pCur.value);
                //修改最近被访问的节点
                pLastVisit = pCur;
            }
		/*这里的else语句可换成带条件的else if:
		else if (pCur->lchild == pLastVisit)//若左子树刚被访问过，则需先进入右子树(根节点需再次入栈)
		因为：上面的条件没通过就一定是下面的条件满足。仔细想想！
		*/
            else
            {
                //根节点再次入栈
                s.push(pCur);
                //进入右子树，且可肯定右子树一定不为空
                pCur = pCur.right;
                while (pCur != null)
                {
                    s.push(pCur);
                    pCur = pCur.right;
                }
            }
        }
    }

    //递归的创建二叉树
    public static TreeNode createBinTree(StringBuilder sb){
        //只能传StringBuilder，不能传String，因为第二次递归必须使用第一次递归使用完之后的数据
        //string虽然也传递的是字串的引用，但递归过程中并不能改变其值substring()返回的是新字串
        char data=sb.charAt(0);
        sb.deleteCharAt(0);
        TreeNode rootNode=null;
        if(data!='#'){
            rootNode=new TreeNode(data);
            rootNode.left=createBinTree(sb);
            rootNode.right=createBinTree(sb);
        }
        return rootNode;
    }


    public static TreeNode initTree(){
        TreeNode G = new TreeNode('G', null, null);
        TreeNode H = new TreeNode('H', null, null);
        TreeNode D = new TreeNode('D', G, H);
        TreeNode B = new TreeNode('B', D, null);
        TreeNode I = new TreeNode('I', null, null);
        TreeNode E = new TreeNode('E', null, I);
        TreeNode F = new TreeNode('F', null, null);
        TreeNode C = new TreeNode('C', E, F);
        TreeNode A = new TreeNode('A', B, C);
        return A;
    }

    public static void main(String args[]) {
//        String str="ABE##FG##H##CI#J###";
//        String str="ABCDE##";
//        TreeNode root=createBinTree(new StringBuilder(str));
        TreeNode root = initTree();
//        preOrder(root);
//        inOrder(root);
        postOrder(root);
        postOrder2(root);
//        PostOrderWithoutRecursion(root);
    }
}
