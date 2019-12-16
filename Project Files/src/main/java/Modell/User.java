package Modell;

import lombok.*;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    private String username;

    private String restore;

    private Map<String,String> learned;

    public String getUsername() {
        return this.username;
    }
}
