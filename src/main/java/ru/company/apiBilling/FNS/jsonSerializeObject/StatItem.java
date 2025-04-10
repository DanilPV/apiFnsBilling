package ru.company.apiBilling.FNS.jsonSerializeObject;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class StatItem {

    @SerializedName("Лимит")
    private int limit;
    @SerializedName("ТипЛимита")
    private String typeLimit;
    @SerializedName("Истрачено")
    private int spent;

    @Override
    public String toString() {
        return "StatItem{" +
                "limit=" + limit +
                ", typeLimit='" + typeLimit + '\'' +
                ", spent=" + spent +
                '}';
    }
}
