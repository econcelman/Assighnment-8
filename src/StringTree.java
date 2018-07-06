

public class StringTree 
{
	Node head = null;
	
	public void addNode(String value)
	{
		Node node = new Node(value);
		if(head == null)
		{
			head = node;
		}
		else
		{
			findOrder(node, head);
		}
	}
	
	public void printTree()
	{
		Node currentNode = head;
		System.out.println(currentNode.value);
		while(currentNode.right != null)
		{
			currentNode = currentNode.right;
			System.out.println(currentNode.value);
		}
	}
	
	public void findOrder(Node newNode, Node oldNode)
	{
		if(oldNode.value.compareToIgnoreCase(newNode.value) > 0)
			insertNode(newNode, oldNode);
		else if(oldNode.right == null)
		{
			newNode.left = oldNode;
			oldNode.right = newNode;
		}
		else
			findOrder(newNode, oldNode.right);
	}
	
	public void insertNode(Node newNode, Node oldNode)
	{
		if(oldNode.left == null && oldNode.right == null)
		{
			if (oldNode.value.compareToIgnoreCase(newNode.value) >= 0)
			{
				oldNode.left = newNode;
				newNode.right = oldNode;
				head = newNode;
			}
			else
			{
				oldNode.right = newNode;
				newNode.left = oldNode;
			}
		}
		else if(oldNode.left == null)
		{
			newNode.right = oldNode;
			oldNode.left = newNode;
			head = newNode;
		}
		else
		{
			newNode.left = oldNode.left;
			newNode.right = oldNode;
			oldNode.left.right = newNode;
			oldNode.left = newNode;
		}
	}
}