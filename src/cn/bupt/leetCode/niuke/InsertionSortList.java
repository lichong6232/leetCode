package cn.bupt.leetCode.niuke;

public class InsertionSortList {
	
	public ListNode insertionSortList(ListNode head) {
		//�ƽڵ�
		ListNode dumy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode pre = dumy;
		while (cur != null) {
			//���浱ǰ�ڵ���һ���ڵ�
			ListNode next = cur.next;
			pre = dumy;
			//Ѱ�ҵ�ǰ�ڵ���ȷλ�õ�һ���ڵ�
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			//����ǰ�ڵ������������
			cur.next = pre.next;
			pre.next = cur;
			//������һ���ڵ�
			cur = next;
			}
		return dumy.next;
    }

}
