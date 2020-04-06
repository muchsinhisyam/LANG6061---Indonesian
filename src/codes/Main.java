package codes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static String[][] Basics = {
            {"What is the word for 'what' in Bahasa Indonesia?",
                    "Kapan", "Siapa", "Apa", "Bagaimana", "3", "Apa->what"
            },
            {"What is the word for 'where' in Bahasa Indonesia?",
                    "Siapa", "Di/Ke mana", "Bagaimana", "Apa", "2", "Di/Ke mana->where"
            },
            {"What is the word for 'when' in Bahasa Indonesia?",
                    "Kemarin", "Siapa", "Di mana", "Kapan", "4", "Kapan->when"
            },
            {
                    "Translate the question below.\n"+"\"Apa yang kamu maksud?\"",
                    "What do you mean?", "Whom do you mean?", "What does she mean?", "What does he mean?", "1", "Yang->do, kamu->you, maksud->mean"
            },
            {
                    "Permisi, _____ kamar kecilnya akan di bersihkan? (Excuse me, _____ will the bathroom be cleaned?)",
                    "Kapan", "Di mana", "Kemarin", "Siapa", "1", "Kapan->When\nSiapa->who\nKemarin->yesterday"
            },
            {
                    "What is the word for 'who' in Bahasa Indonesia?",
                    "Kapan", "Kemarin", "Di mana", "Siapa", "4", "Kapan->When\nSiapa->who\nKemarin->yesterday"
            },
            {
                    "What is the word for 'why' in Bahasa Indonesia?",
                    "Kenapa", "Siapa", "Kapan", "Kemarin", "1", "Kapan->When\nSiapa->who\nKemarin->yesterday"
            },
            {
                    "What is the word for 'how' in Bahasa Indonesia?",
                    "Apa", "Bagaimana", "Kemarin", "Kapan", "2", "Bagaimana->how\nKapan->When\nSiapa->who\nKemarin->yesterday\nSiapa->who"
            },
            {
                    "Translate the question below.\n"+"\"Siapa yang akan pergi ke mall dengan saya?\"",
                    "Why do you want to go to the mall with me?", "Where do you want to go?", "Who will go to the mall with me?", "When will we go to the mall?", "3", "Yang akan->will, pergi->go, ke->to, dengan->with, saya->I/me"
            },
            {
                    "What is the meaning of the question below?\n"+"\"Kenapa anda menyukai hidangan Korea?\"",
                    "Do you like Korean dish?", "What makes you like Korean dish?", "What do you like about Korean dish?", "Why do you like Korean dish?", "4", "Anda->you, menyukai->like, hidangan->dish"
            },
            {
                    "Translate the question below.\n"+"\"Bagaimana dengan kau/kamu?\"",
                    "How about him?", "How about her?", "How about you?", "How about Grandma?", "3", "\"Dengan\" usually refers to the word \"with\" but in this case it means \"about\", kau/kamu->you"
            },
            {
                    "What is the word for 'I' in Bahasa Indonesia?",
                    "Saya", "Dia", "Kamu", "Nenek", "1", "Saya->I"
            },
            {
                    "What is the word for 'you' in Bahasa Indonesia?",
                    "Nenek", "Dia", "Saya", "Kamu/Anda", "4", "Kamu/Anda->you"
            },
            {
                    "What is the word for 'he', 'she', and 'it' in Bahasa Indonesia?",
                    "Nenek", "Kamu", "Dia", "Saya", "3", "Dia->he/she/it"
            },
            {
                    "What is the meaning of the sentence below?\n"+"\"Saya menyukai bunga.\"",
                    "I like flowers.", "She likes flowers.", "He likes flowers.", "My grandmother likes flowers.", "1", "Menyukai->like, bunga->flowers"
            },
            {
                    "Translate the question below.\n"+"\"Kenapa anda menyukai bunga?\"",
                    "Why does he like flowers?", "Why do you like flowers?", "Why does grandmother like flowers?", "Why does she like flowers?", "2", "Kenapa anda menyukai bunga->Why do you like flowers?"
            },
            {
                    "Choose the correct sentence from the options which translates to the statement below.\n"+"\"She likes flowers.\"",
                    "Kamu menyukai bunga.", "Saya menyukai bunga.", "Bunga menyukai dia.", "Dia menyukai bunga", "4", "She likes flowers->Dia menyukai bunga"
            }
    };

    public static String[][] Travel = {
        {"What is the word for 'Airport' in Bahasa Indonesia?", "Rumah Makan", "Diskotek", "Apotek", "Bandara", "4", "Hint: \nAirport -> Bandara\nRestaurant -> Rumah Makan\nDisco -> Diskotek\nPharmacy -> Apotek"},
        {"What is the word for 'Hospital' in Bahasa Indonesia?", "Apotek", "Diskotek", "Rumah Sakit", "Restoran", "3", "Hints: \nHospital -> Rumah Sakit\nRestaurant -> Rumah Makan\nDisco -> Diskotek\nPharmacy -> Apotek"},
        {"What is the word for 'Restaurant' in Bahasa Indonesia?", "Rumah Makan/Restoran", "Kamar Mandi", "Apotek", "Bandara", "1", "Hints:\nRestaurant -> Rumah Makan\nToilet -> Kamar Mandi\nPharmacy -> Apotek\nAirport -> Bandara"},
        {"What is the word for 'How Much' in Bahasa Indonesia?", "Berapa", "Mengapa", "Kenapa", "Apa", "1", "Hints: \nHow Much -> Berapa\nWhy -> Mengapa\nWhy -> Kenapa\nWhat -> Apa"},
        {"What is the meaning of the sentence below? \nSaya mau makan di restoran.", "He wants to eat in a restaurant", "I don't want to eat in a restaurant", "I want to eat in a restaurant", "They want to eat in a restaurant", "3", "Hints: \nMau->want\nmakan->eat\ndi->in"},
        {"Select the correct sentence which translates to the question below. \nBerapa harga hidangan ini?", "How much does that dish cost?", "How much does this dish cost?", "Where can I buy this dish?", "Where can I buy that dish?", "2", "Hint: \nharga->price/cost\nhidangan->dish\nini->this"},
        {"Translate the sentence below. \nSaya mau pergi ke bandara.", "I want to go to a restaurant.", "I want to go to the airport.", "I want to go to the hospital.", "I want to go to university.", "2", "Hint: \nmau->want \npergi ke->go to"}
    };

    // Hint still missing
    public static String[][] Time = {
            {"What is 'day' in Bahasa Indonesia?",
                    "Bulan", "Tahun", "Besok", "Hari", "4", "Bulan->month, tahun->year, besok->Tomorrow"
            }
            ,
            {"What is 'Yesterday' in Bahasa Indonesia?",
                    "Kemarin", "Hari", "Hari ini", "Bulan", "1", "Hari ini->today, bulan->month"
            }
            ,
            {"What is 'Today' in Bahasa Indonesia?",
                    "Hari", "Besok", "Hari ini", "Tahun depan", "3", "Besok->tomorrow, tahun depan->next year"
            }
            ,
            {
                    "What is 'Tomorrow' in Bahasa Indonesia?",
                    "Tahun depan", "Bulan depan", "Hari", "Besok", "4", "Tahun depan->next year, bulan depan->next year"
            }
            ,
            {
                    "What is the meaning of the question below?\n"+"\"Hari ini adalah hari apa?\"",
                    "What day is it today?", "What day is it tomorrow?", "What is the date today?", "Tomorrow is Tuesday.", "1", "adalah->is, apa->what"
            }
            ,
            {
                    "What is the meaning of the sentence below?\n"+"\"Kemarin saya makan es krim.\"", "I ate an ice cream today.", "I ate an ice cream yesterday.", "I will eat an ice cream tomorrow.", "I hate ice creams.", "2", "Saya->I, makan->eat/ate, es krim->ice cream"
            }
            ,
            {"Translate the sentence below.\n"+"\"Besok saya akan pulang ke Amerika Serikat.\"",
                    "I will return to the US tomorrow.", "I won't return to the US.", "Yesterday I returned to the US.", "I will return to the US today.", "1", "Akan->will, pulang->return, ke->to, Amerika Serikat->USA"
            }
    };

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        String css = Main.class.getResource("Main.css").toExternalForm();

        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setResizable(false);

        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setTitle("Study Belajar");
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}