package ChallengeTen.LinkedList.structure;


import ChallengeTen.LinkedList.data.LinkedListNode;

import java.util.ArrayList;

public class LinkedList {
    public LinkedListNode head;
    public LinkedListNode head1;
    private int size;
    private Exception IOException;

    public void insert(String data) { // adding in the first node in the linkedlist
        if (head == null) {
            LinkedListNode node = new LinkedListNode(data);
            head = node;
        } else {
            LinkedListNode newNode = new LinkedListNode(data);
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }

    public void append(String data) { // adding at the last node in the linkedlist
        if (head == null) {
            LinkedListNode node = new LinkedListNode(data);
            head = node;
        } else {
            LinkedListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            LinkedListNode node = new LinkedListNode(data);
            current.setNext(node);
        }
        size++;
    }

    public boolean include(String data) {
        if (head == null) {
            LinkedListNode node = new LinkedListNode(data);
            head = node;
        } else {
            LinkedListNode current = head;
            while (current != null) {
                if (current.getData() == data) {
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }


    public void insertBefore(String data, String before) {
        LinkedListNode node = new LinkedListNode(before);
        if (head == null) {
            System.out.println("this " + data + " Not Exist in the linked list ");
            return;
        } else if (data == head.getData()) { // if the data exists in the first node
            node.next = head;
            head = node;
            size++;
        } else {
            LinkedListNode temp = head;
            while (temp.next != null) {
                if (temp.next.getData() == data) {
                    node.next = temp.next;
                    temp.next = node;
                    size++;
                    return;
                }
                temp = temp.next;
            }
            System.out.println("this " + data + " Not Exist in the linked list ");
        }
    }

    public void insertAfter(String data, String after) {
        LinkedListNode node = new LinkedListNode(after);
        if (head == null) {
            System.out.println("this " + data + " Not Exist in the linked list ");
            return;
        } else {
            LinkedListNode temp = head;
            while (temp != null) {
                if (temp.getData() == data) {
                    node.next = temp.next;
                    temp.next = node;
                    size++;
                    return;
                }
                temp = temp.next;
            }
            System.out.println("this " + data + " Not Exist in the linked list ");
        }
    }


    public int getSize() {
        return size;
    }


    public String kth(int index) {
//        LinkedListNode current = head;
        if (head == null) {
            System.out.println("The list is empty please insert node.");
        }
        if (index > getSize() - 1 || index < 0) {
            return "Exception";
        }
        LinkedListNode current = head;

        int i = 0;
        while (i < (getSize() - index - 1)) {
            current = current.getNext();
            i++;
        }
        return current.getData();
    }


    public LinkedList zipLists(LinkedList list1, LinkedList list2) {
        if (list1.head == null && list2.head == null) {
            System.out.println("Both lists are empty");
            return null;
        } else if (list1.head == null) {
            return list2;
        } else if (list2.head == null) {
            return list1;
        } else {
            LinkedListNode current1 = list1.head;
            LinkedListNode current2 = list2.head;
            LinkedListNode ref1, ref2;
            while (current1.getNext() != null && current2 != null) {
                ref1 = current1.getNext();
                ref2 = current2.getNext();
                current1.setNext(current2);
                current2.setNext(ref1);
                current1 = ref1;
//    (I can use one of them they are the same L:152)  current1=current1.getNext().getNext();
                current2 = ref2;
                size++;
                if (current1.getNext() == null) {
                    current1.setNext(current2);
                    break;
                }
            }
        }
        return list1;
    }

    public LinkedList reversedLinkedList(LinkedList list) {
        LinkedListNode current = list.head;
        LinkedListNode previous = null;
        LinkedListNode next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        list.head = previous;
        return list;
    }


    public LinkedListNode reversedNode(LinkedListNode node) {
        LinkedListNode prev = null;
        while (head != null) {
            LinkedListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;

        }
        return prev;
    }

    public boolean palindrome() {
        if (this.head == null) {
            System.out.println("List is empty");
            return false;
        }
        ArrayList<String> arr = new ArrayList<>();
        LinkedListNode current = this.head;
        while (current != null) {
            arr.add(current.getData());
            current = current.getNext();
        }
        for (int i = 0; i < arr.size() / 2; i++) {
            if (!arr.get(i).equals(arr.get(arr.size() - i - 1))) {
                return false;
            }
        }
        return true;
    }


    // practicing :

    public LinkedListNode sortList(LinkedListNode head) {
        LinkedListNode current1 = head;
        LinkedListNode current2 = current1.getNext();
        while (current1 != null) {
            while (current2 != null) {
                if (Integer.parseInt(current2.getData()) < Integer.parseInt(current1.getData())) {
                    String value = current1.getData();
                    current1.setData(current2.getData());
                    current2.setData(value);
                }
                current2 = current2.next;
            }
            current1 = current1.next;
            current2 = current1;
        }
        return head;
    }



    public String remove(int index) throws IndexOutOfBoundsException {
        String deletedNode = "";
        if (head == null) {
            System.out.println("List is empty");
        } else {
            if (index > size || index < 0) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            // if deleting first node
            if (index == 0) {
                deletedNode = head.getData();
                head = head.getNext();
                size--;
                return deletedNode;
            }

            int counter = 0;

            LinkedListNode previous = null;
            LinkedListNode current = head;

            while (counter != index) {
                previous = current;
                current = current.getNext();
                counter++;
            }

            previous.setNext(current.getNext());
            current.setNext(null);
            deletedNode = current.getData();
            size--;
        }

        return deletedNode;
    }






    @Override
    public String toString() {
        String printing = "";
        if (head == null) {
            System.out.println("THE LIST IS EMPTY ");
        } else {
            LinkedListNode current = head;
            while (current != null) {
                printing = printing + " { " + current.getData() + " } " + " -> ";
                current = current.getNext();
            }
            printing = printing + " NULL ";
        }
        return printing;
    }

}