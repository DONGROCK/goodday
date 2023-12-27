package practiceapi.response;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dongrock")
class ResponseRestController {

    @GetMapping("/pig")
    public String pig() {
        return "뚱뚱한 동락입니다.";

    }
    @GetMapping("/rion")
    public String rion(){
        return "사나운 동락입니다만.";
    }

    @GetMapping("/weight")
    public int weight(){
        return 63;
    }
    @GetMapping("/lottonum")
    public int lottoNumOnlyOne(){
        return (int)(Math.random()*45) + 1;
    }

    @GetMapping("/history")
    public Message getMessage(){
        return new Message(1592,"임진왜란");
    }
    @GetMapping("/foodlist")
    public List<String> foodList(){
        return List.of(new String[] {"치킨","떡볶이","콜라"});
    }

    @GetMapping("/treshlist")
    public List<String> trash(){
        return List.of(new String[] {"민트","토마토","고수"});
    }

    @GetMapping("/historybook")
    public Map<Integer, String> gethistory(){

        List<Message> historyBook = new ArrayList<>();
        historyBook.add(new Message(1592,"임진왜란"));
        historyBook.add(new Message(1998,"동락태어남"));
        historyBook.add(new Message(2002,"월드컵4강"));

        return historyBook.stream().collect(Collectors.toMap(Message::getYear, Message::getEvent));

    }

    @GetMapping(value = "image", produces = MediaType.IMAGE_PNG_VALUE)
    private byte[] getImage() throws IOException {
        return getClass().getResourceAsStream("/images/devil.PNG").readAllBytes();
    }

    @GetMapping("/entity")
    public ResponseEntity<Message> getEntity(){
        return ResponseEntity.ok(new Message(2018,"입대"));
    }
}
