import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;



public class eventJoke extends ListenerAdapter {
    public eventJoke() throws IOException {
    }

    public static Document getPage() throws IOException {
        String url = "https://icanhazdadjoke.com/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
    Document page = getPage();
    Elements joke = page.select("p[class = subtitle]");
    String clear_text = joke.text();


    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String messageSent = event.getMessage().getContentRaw();
        if(messageSent.equalsIgnoreCase("!show")){
            event.getChannel().sendMessage("Твой анекдот:  " + clear_text).queue();
        }
        if(messageSent.equalsIgnoreCase("!info")) {
            event.getChannel().sendMessage("1. используйте команду !show чтобы бот отправил Вам анекдот").queue();
        }
   }

}
