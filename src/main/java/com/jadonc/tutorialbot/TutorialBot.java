package com.jadonc.tutorialbot;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.concurrent.ConcurrentNavigableMap;

public class TutorialBot {

    private final Dotenv config;
    private final ShardManager shardManager;

    public TutorialBot() throws LoginException {
        config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Jadon Program like a boss!!11"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public Dotenv getConfig() {
        return config;
    }

    public static void main(String[] args) {
        try {
            TutorialBot tutorialBot = new TutorialBot();
        } catch(LoginException e) {
            System.out.println("ERROR: Provided Login Token is INVALID!");
        }

    }
}
