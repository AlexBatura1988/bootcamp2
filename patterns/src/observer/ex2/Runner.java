package observer.ex2;


import observer.ex2.listeners.AppListener;
import observer.ex2.listeners.EmailListeners;
import observer.ex2.objects.FacebookUser;
import observer.ex2.objects.FollowType;
import observer.ex2.publisher.FacebookPage;

public class Runner {

	public static void main(String[] args) {
		FacebookPage facebookPage = new FacebookPage("Coding Memes");

		FacebookUser john = new FacebookUser("John", "john@gmail.com");
		FacebookUser jane = new FacebookUser("Jane", "jane@gmail.com");
		
		AppListener johnAppNotification = new AppListener(john);

        facebookPage.follow(FollowType.VIDEO, johnAppNotification);
        facebookPage.follow(FollowType.LIVE_STREAM, johnAppNotification);
        facebookPage.follow(FollowType.ARTICLE, johnAppNotification);
        
        EmailListeners janeEmailNotification = new EmailListeners(jane);
        AppListener janeAppNotification = new AppListener(jane);
        
        facebookPage.startLiveStream("https://example.com/livestream");
        facebookPage.publishVideo("https://example.com/video");
        
        


	}
	

}
