// C++ program to demonstrate inserting a node BEFORE a given node in a linked list
#include <bits/stdc++.h>
using namespace std;

// structure for a node in the linked list
struct Node {
	int data;    // data of the node
	Node* next;  // pointer to the next node in the list

	// constructor of Node
	Node(int val, Node* link = 0)
		: data(val), next(link)
	{
	}
};

// create a head node with data 20
Node* head = new Node(20);

// function to print the linked list starting from the given node
void printList(Node* n)
{
	// loop until the current node is not NULL
	while (n != NULL) {

		// print the data of the current node
		cout << n->data << " ";
		n = n->next;
	}
}

// function to add a node before the given node, excluding the head node
void addBefore(Node* given_ptr, int val)
{

	// check if the given pointer is the address of head
	if (head == given_ptr) {

		// create a new node with the specified value
		Node* n = new Node(val);

		// point the new node's next to the current head
		n->next = head;

		// update the head pointer to the new node
		head = n;
		return ;
	}

	// if the given pointer is not the head
	else {

		Node *p, *n = head;

		// traverse the list to find the previous node of the given node
		// this loop will return 'p' as the previous pointer of the given node
		for (n, p; n != given_ptr; p = n, n = n->next);

		// create a new node with the specified value
		Node* m = new Node(val);

		// update the 'm->next'
		m->next = p->next;

		// update the next pointer of the previous node to the new node 'm'
		p->next = m;

	}
}

int main()
{
	// set the next of the head node to a new node with data 4
	head->next = new Node(4);

	// call the function to add a node with value 8 before the node following the head
	addBefore(head->next,11);

	// printing the linked list
	printList(head);
}
