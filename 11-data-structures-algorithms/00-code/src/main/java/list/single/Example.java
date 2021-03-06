package list.single;

import list.ListNode;

public class Example {


    /**
     * 插入头节点
     */
    public static void insertHead(ListNode head, ListNode newNode) {
        //记录下原来节点的引用
        ListNode old = head;
        //头结点设置为新插入的及诶单
        head = newNode;
        //头结点的后续节点设置为老的元素
        head.next = old;
    }

    /**
     * 插入尾节点
     */
    public static void insertTail(ListNode tail, ListNode newTail) {
        ListNode old = tail;
        tail = newTail;
        tail.next = null;
        old.next = tail;
    }

    /**
     * 遍历
     */
    public static void traverse(ListNode head) {
        while (head != null) {
            System.out.println(head.value + "");
            head = head.next;
        }
        System.out.println();
    }


    /**
     * 遍历查找
     */
    public static int find(ListNode head, int value) {
        int index = -1;
        int count = 0;
        while (head != null) {
            if (head.value == value) {
                index = count;
                return index;
            }
            count++;
            head = head.next;
        }
        return index;
    }

    /**
     * 插入节点
     */
    public static void insert(ListNode p, ListNode s) {
        ListNode next = p.next;
        p.next = s;
        s.next = next;
    }


    /**
     * 删除
     */
    public static void delete(ListNode head, ListNode q) {
        if (q != null && q.next != null) {
            ListNode p = q.next;
            q.value = p.value;
            q.next = p.next;
            p = null;
        }
        //删除最后一个元素
        if (q != null && q.next == null) {
            while (head != null) {
                if (head.next != null && head.next == q) {
                    head.next = null;
                    break;
                }
                head = head.next;
            }
        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
//
//        traverse(node1);
//        Node newHead = new Node(0);
//        insertHead(node1, newHead);
//        traverse(newHead);
//
//        Node newTail = new Node(4);
//        insertTail(node3, newTail);
//        traverse(newHead);
//
//        //验证查找
//        System.out.println(find(newHead, 3));
//
//        //
//        insert(node3, new Node(99));
//        traverse(newHead);
//
//        //删除
//        delete(newHead, node3);
//        traverse(newHead);


//        Node node = reverseList(node1);
//        traverse(node);
        System.out.println(middleNode(node1).value);
    }


    /**
     * 翻转
     * 时间复杂度O(n), 空间复杂度O(1)
     */
    public static ListNode reverseList(ListNode head) {
        //当前节点的上一个节点
        ListNode pre = null;
        // 当前节点的下一个节点
        ListNode next = null;
        while (head != null) {
            //记录一下下一个节点的位置
            next = head.next;
            //将当前节点的尾指针指向它前一个位置
            head.next = pre;
            //往后移动一位
            pre = head;
            //往后移动一位
            head = next;
        }
        return pre;
    }

    /**
     * 取中间节点 , 偶数个取得中间节点是前面那个
     */
    public static ListNode getMid(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode middleNode(ListNode head) {
        int tail = 0;
        ListNode copy = head;
        while(copy != null && copy.next != null){
            copy = copy.next;
            tail++;
        }
        tail = tail /2;
        while(tail > 0){
            head = head.next;
            tail--;
        }
        return head;
    }
}
