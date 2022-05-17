package observer.ex2.listeners;

import observer.ex2.objects.FacebookUser;

public class EmailListeners implements EventListener {
	private FacebookUser user;

	public EmailListeners(FacebookUser user) {
		this.user = user;
	}

	@Override
	public void update(String eventType, String displayName, String url) {
		System.out.println("Email Notification >> hey " + this.user.getFirstName() + ", " + displayName
				+ " postet new content: " + eventType + " >> " + url);
	}

}
