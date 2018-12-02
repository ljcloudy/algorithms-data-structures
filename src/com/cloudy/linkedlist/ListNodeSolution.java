package com.cloudy.linkedlist;

/**
 * Created by ljy_cloudy on 2018/11/25.
 */
public class ListNodeSolution {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;

            while (cur != null) {
                sb.append(cur.val).append("->");
                cur = cur.next;
            }
            sb.append("Null");
            return sb.toString();
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode first = head;
        ListNode second = head;

        while (first != null && second != null) {

            first = first.next;
            if (second.next != null) {
                second = second.next.next;
            }
            if (first == second) {
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (first != null && second != null) {

            if (second.next == null) {
                break;
            }
            second = second.next.next;
            first = first.next;
            if (first == second) {
                second = head;
                while (first != second) {
                    first = first.next;
                    second = second.next;
                }
                return first;
            }
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        int aSize = 0;
        int bSize = 0;

        while (a != null) {
            aSize++;
            a = a.next;
        }
        while (b != null) {
            bSize++;
            b = b.next;
        }
        int diff = aSize - bSize;
        a = headA;
        b = headB;
        if (diff > 0) {
            while (diff != 0 && a != null) {
                a = a.next;
                diff--;
            }
        } else {
            while (diff != 0 && b != null) {
                b = b.next;
                diff++;
            }
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        ListNode pre = null;
        int index = 0;
        while (cur != null) {
            if (index == count - n) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = head.next;
                }

                break;
            }
            pre = cur;
            cur = cur.next;
            index++;
        }

        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode first = head;
        while (n-- != 0) {
            first = first.next;
        }
        if (first == null) {
            return head.next;
        }
        ListNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return second;
    }

    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = result.next;
            result.next = temp;
        }

        return result.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                if (pre != null) {
                    pre.next = cur.next;
                } else {
                    head = head.next;
                    pre = null;
                }
            } else {
                pre = cur;
            }

            cur = cur.next;
        }
        return head;
    }

    public static ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null && cur.next != null) {
            ListNode temp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = temp;
            cur = cur.next;
            pre = pre.next;
        }

        return head;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            index++;
            cur = cur.next;
        }
        int[] nums = new int[index];

        cur = head;
        index = 0;
        while (cur != null) {
            nums[index++] = cur.val;
            cur = cur.next;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] != nums[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode first = head;
        ListNode second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        second = reverseList(first);
        first = head;
        while (second != null) {
            if (second.val != first.val) {
                return false;
            }
            second = second.next;
            first = first.next;
        }

        return true;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode first = l1;
        ListNode second = l2;

        ListNode node = new ListNode(0);

        ListNode cur = node;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            } else {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }

        return node.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int index = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.val;
            }
            if (l2 != null) {
                val2 = l2.val;
            }

            int val = val1 + val2;
            if (index == 1) {
                val += 1;
                index = 0;
            }
            if (val >= 10) {
                index = 1;
            }
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode node = cur.next;
            while (node.next != null && node.next.val == node.val) {
                node = node.next;
            }
            if (node != cur.next) {
                cur.next = node.next;
            } else {
                cur = cur.next;
            }

        }
        return dummy.next;
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            ListNode next = node2 != null ? node2.next : null;

            node1.next = next;
            if (node2 != null) {
                node2.next = node1;
                cur.next = node2;
                cur = cur.next.next;
            } else break;
        }
        return dummy.next;
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            ListNode node = dummy;
            while (node.next != null && node.next.val < cur.val) {
                node = node.next;
            }
            cur.next = node.next;
            node.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            cur = cur.next;
            index++;
        }
        k %= index;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode first = head, second = head;
        for (int i = 0; i < k + 1; i++) {
            if (second != null) {
                second = second.next;
            } else {
                second = head.next;
            }
        }
        while (second != null) {
            first = first.next;
            second = second.next;

        }

        ListNode temp = first.next;
        first.next = null;
        ListNode node = dummy.next;
        dummy.next = temp;

        second = dummy;
        while (second.next != null) {
            second = second.next;
        }
        second.next = node;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
//
//        ListNode listNode2 = new ListNode(1);
//        listNode2.next = new ListNode(2);
//        listNode2.next.next = new ListNode(4);

        ListNode node = rotateRight(listNode, 6);
        System.out.println(node);

    }
}
