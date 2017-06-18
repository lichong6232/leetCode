package cn.bupt.leetCode;

public class HasCycle {
	
	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
		ListNode fast=head,slow=head;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow)
				return true;
		}
		if(fast==null||fast.next==null)
			return false;
		return true;
        
    }

}
