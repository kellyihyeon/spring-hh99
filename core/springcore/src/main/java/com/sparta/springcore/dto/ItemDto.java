package com.sparta.springcore.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@NoArgsConstructor // 기본 생성자를 자동으로 만듭니다.
@Getter
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;

    // JSONObject 라이브러리를 가져와야 사용할 수 있다.
    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}