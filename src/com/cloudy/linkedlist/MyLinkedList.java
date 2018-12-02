package com.cloudy.linkedlist;

class MyLinkedList {

    private Node head;


    private class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur != null) {
                cur = cur.next;
            }
        }
        if (cur != null) {
            return cur.val;
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val, null);

        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val, null);
        } else {
            Node cur = head;
            Node tail = null;
            while (cur != null) {
                Node next = cur.next;
                if (next == null) {
                    tail = cur;
                    break;
                }
                cur = next;
            }
            tail.next = new Node(val, null);
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        Node cur = head;
        Node pre = null;
        for (int i = 0; i < index; i++) {
            if (cur != null) {
                pre = cur;
                cur = cur.next;
            }
        }
        if (pre != null) {
            pre.next = new Node(val, cur);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node cur = head;
        Node pre = null;
        for (int i = 0; i < index; i++) {
            if (cur != null) {
                pre = cur;
                cur = cur.next;
            }
        }
        if (pre != null) {
            if (cur != null) {
                pre.next = cur.next;
            }
        }

    }



    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(5);
        linkedList.addAtHead(2);
        linkedList.deleteAtIndex(1);
        linkedList.addAtIndex(1, 9);
        linkedList.addAtHead(4);
        linkedList.addAtHead(9);
        linkedList.addAtHead(8);
        int i = linkedList.get(3);
        System.out.println(i);

    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */