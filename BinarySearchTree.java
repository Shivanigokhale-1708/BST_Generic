import java.util.Scanner;
import java.util.Stack;

class Node<T>
{
	 T data;
	Node<T> left;
	Node<T> right;
	public Node(T d)
	{
		data=d;
		
	}

}
public class BinarySearchTree<T extends Comparable<T>>{

	Node<T> root=null;
	Scanner sc=new Scanner(System.in);
	int choice;
	
	public void generate_tree(Node<T> node){
		
		System.out.println("inserting data:"+node.data+" in binary tree");     //inserting data in binary tree
		 
			if(root==null)
			{
				root=node;
			}
		
		
		else{
			Node<T> ptr=root;
		while(ptr!=null)
		{
			
			              
			if(node.data.compareTo(ptr.data)<0)
			{
				if(ptr.left!=null)
				{
					ptr=ptr.left;
					                    //left child already exist so traverse till left child of node is null
				}
				else{
					ptr.left=node;
					break;                    //left child of node is now null so new data can be inserted here.
				}
			}
			else if(node.data.compareTo(ptr.data)>0)
			{
				if(ptr.right!=null)
				{
					ptr=ptr.right;      // right child already exist so traverse till left child of node is null
					
				}
				else{
					ptr.right=node;    //right child of node is now null so new data can be inserted here.
					break;            
				} 
			}
			
			
		}
		
		}
		
		
		
	}
	public void inorder_recursive(Node<T> node)
	{
	if(node!=null){
		inorder_recursive(node.left);        //Traverse left
		System.out.println(node.data);        //Display data
		
		inorder_recursive(node.right);         //Traverse right
	}
	}
	public void preorder_non_recursive(Node<T> node)
	{
		Stack<Node> s=new Stack<Node>();
		Node<T> ptr=root;
		do{
			while(ptr!=null)
			{
				System.out.println(ptr.data);       //display cuurent data
				s.push(ptr);
				ptr=ptr.left;                      //traverse left
			}
			if(!s.isEmpty())
			{
				ptr=s.pop();
				ptr=ptr.right;             //traverse right
			}
		}while(!s.isEmpty()|| ptr!=null);
		
	}
	public void postorder_non_recursive(Node<T> node)
	{
		Stack<Node> s=new Stack<Node>();
		Stack<String> f=new Stack<String>();
		Node<T> ptr=root;
		String flag1,flag2;
		do{
			while(ptr!=null)
			{
				s.push(ptr);               //Here 2 stacks are used beacause once left child is traversed a flag is maintained.
				f.push("L");
				ptr=ptr.left;
			}
			if(!s.isEmpty())
			{
				ptr=s.pop();
				flag1=f.pop();
				if(flag1.equals("L"))               //if node's left child is already traversed then push right flag in stack
				{
					s.push(ptr);
					f.push("R");
					ptr=ptr.right;
				}
				else{
					System.out.println(ptr.data);   //both left and right child are traversed so print the data.
					ptr=null;
				}
			}
		}while(!s.isEmpty() || ptr!=null);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer> tree=new BinarySearchTree<Integer>();
		Scanner s=new Scanner(System.in);
        
		tree.generate_tree(new Node<Integer>(60));    //Inserting root node
		tree.generate_tree(new Node<Integer>(30));
		tree.generate_tree(new Node<Integer>(80));     
		tree.generate_tree(new Node<Integer>(10));
		tree.generate_tree(new Node<Integer>(50));
		tree.generate_tree(new Node<Integer>(70));   
		tree.generate_tree(new Node<Integer>(90));   
		System.out.println("inorder traversal of tree is:");
		tree.inorder_recursive(tree.root);
		System.out.println("preorder traversal of tree is:");
		tree.preorder_non_recursive(tree.root);
		System.out.println("postorder traversal of tree is:");
		tree.postorder_non_recursive(tree.root);
	}

}
/*inserting data:60 in binary tree
inserting data:30 in binary tree
inserting data:80 in binary tree
inserting data:10 in binary tree
inserting data:50 in binary tree
inserting data:70 in binary tree
inserting data:90 in binary tree
inorder traversal of tree is:
10
30
50
60
70
80
90
preorder traversal of tree is:
60
30
10
50
80
70
90
postorder traversal of tree is:
10
50
30
70
90
80
60
*/