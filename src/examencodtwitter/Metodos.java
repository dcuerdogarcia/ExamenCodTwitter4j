package examencodtwitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JOptionPane;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author dcuerdogarcia
 */
public class Metodos {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    Twitter twitter;

    public Metodos() {
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("xxx")
                .setOAuthConsumerSecret("xxxx")
                .setOAuthAccessToken("xxxxxxx")
                .setOAuthAccessTokenSecret("xxxxxxxxxxxxxxx");
        twitter = new TwitterFactory(cb.build()).getInstance();

    }

    //  1.- Mostrar línea de tiempo
    public void timeLine() {
        try {

            ResponseList<twitter4j.Status> statuses = twitter.getHomeTimeline();
            System.out.println("Showing home timeline.");
            for (twitter4j.Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //  2.- Mostrar Tweets con String introducida
    public void buscar() {

        try {

            String preg = JOptionPane.showInputDialog("Buscar:");
            Query query = new Query(preg);
            QueryResult result = twitter.search(query);
            for (twitter4j.Status status : result.getTweets()) {
                System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
            }
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //  3.- Tweetear.
    public void publicarUnTweet() {
        try {

            String twet = JOptionPane.showInputDialog("Tweett:");
            twitter4j.Status status = twitter.updateStatus(twet);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        } catch (TwitterException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
    

