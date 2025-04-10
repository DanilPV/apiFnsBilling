package ru.company.apiBilling.FNS.jsonSerializeObject;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class StatResponse {

    @SerializedName("ДатаНач")
    private String dateBegin;
    @SerializedName("ДатаОконч")
    private String dateEnd;
    @SerializedName("Методы")
    private Map<String, StatItem> methodList;

    @Override
    public String toString() {
        return "StatDtoList{" +
                "dateBegin='" + dateBegin + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", methodList=" + methodList +
                '}';
    }
}
