package observer.ex2.publisher;

import observer.ex2.listeners.EventListener;
import observer.ex2.objects.FollowType;

public class FacebookPage {

	private String displayName;
	private EventManager eventManager;

	public FacebookPage(String displayName) {
		this.displayName = displayName;
		this.eventManager = new EventManager(FollowType.VIDEO, FollowType.LIVE_STREAM, FollowType.ARTICLE);
	}

	public void follow(String eventType, EventListener listener) {
		this.eventManager.subscribe(eventType, listener);
	}

	public void unfollow(String eventType, EventListener listener) {
		this.eventManager.unsubscribe(eventType, listener);
	}

	public void publishVideo(String url) {
		this.eventManager.notify(FollowType.VIDEO, this.displayName, url);
	}

	public void startLiveStream(String url) {
		this.eventManager.notify(FollowType.LIVE_STREAM, this.displayName, url);
	}

	public void publishArticle(String url) {
		this.eventManager.notify(FollowType.ARTICLE, this.displayName, url);
	}

}
