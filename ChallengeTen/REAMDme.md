Stacks and Queues
Stack is a linear data structure in which elements can be inserted and deleted only from one side of the list, called the top. A stack follows the LIFO (Last In First Out) principle.The insertion of an element into stack is called push operation, and deletion of an element from the stack is called pop operation.

Queue is a linear data structure in which elements can be inserted only from one side of the list called rear, and the elements can be deleted only from the other side called the front. The queue data structure follows the FIFO (First In First Out) principle.The insertion of an element in a queue is called an enqueue operation and the deletion of an element is called a dequeue operation.

Challenge
This challenge about how to build and using the Stack and Queue to store nodes in it and also how to apply methods on it like push method to delete node in stack and dequeue to delete node in queue.

Approach & Efficiency
Space: O(1)
Time: O(1)
API
Methods in Stack
push(int value) : To add new node in the stack.

pop(): Removes the node from the top of the stack.

peek() : Returns Value of the node located at the top of the stack.

isEmpty() : Boolean indicating whether or not the stack is empty.

Methods in Queue
enqueue(int value): To add new node in the queue.

dequeue() : Removes the node from the front of the queue.

peek() : Returns Value of the node located at the front of the queue.

isEmpty() : Boolean indicating whether or not the queue is empty.