package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FriendListResponse {

    @JsonProperty("friendslist")
    private FriendsList friendsList;

    //test commit

    public void setFriendsList(FriendsList friendsList) {
        this.friendsList = friendsList;
    }

    public static class FriendsList {
        @JsonProperty("friends")
        private List<Friend> friends;

        public List<Friend> getFriends() {
            return friends;
        }

        public void setFriends(List<Friend> friends) {
            this.friends = friends;
        }
    }
}