package com.richardbreslin.westeam.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Friend implements Serializable {
    private String steamid;
    private String relationship;
    private Integer friend_since;
}
