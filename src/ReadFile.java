import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {
    //declare list of strings
    List<String> wholeFile;
    List<String> splitFile;
    int fileLength;

    List<Integer> year;
    List<Integer> daysWithOneHundredthInchPrec;
    List<Integer> daysWithOneTenthInchPrec;
    List<Integer> daysWithOneInchPrec;
    List<Integer> daysWithOneInchSnowDepth;
    List<Integer> daysWithOneInchSnowFall;
    List<Integer> daysWithMinTempLessOrEqual0;
    List<Integer> daysWithMinTempLessOrEqual32;
    List<Integer> daysWithMinTempLessOrEqual90;
    List<Integer> daysWithMaxTempLessOrEqual32;
    List<Integer> daysWithMaxTempLessOrEqual70;
    List<Integer> daysWithFog;
    List<Integer> daysWithHeavyFog;
    List<Integer> daysWithOneOrMoreStorm;
    List<Integer>[] dataCategories = new ArrayList[14];

    //constructor
    public ReadFile(String file) throws IOException {
        year = new ArrayList<>();
        daysWithOneHundredthInchPrec = new ArrayList<>();
        daysWithOneTenthInchPrec = new ArrayList<>();
        daysWithOneInchPrec = new ArrayList<>();
        daysWithOneInchSnowDepth = new ArrayList<>();
        daysWithOneInchSnowFall = new ArrayList<>();
        daysWithMinTempLessOrEqual0 = new ArrayList<>();
        daysWithMinTempLessOrEqual32 = new ArrayList<>();
        daysWithMaxTempLessOrEqual32 = new ArrayList<>();
        daysWithMaxTempLessOrEqual70 = new ArrayList<>();
        daysWithMinTempLessOrEqual90 = new ArrayList<>();
        daysWithFog = new ArrayList<>();
        daysWithHeavyFog = new ArrayList<>();
        daysWithOneOrMoreStorm = new ArrayList<>();

        //constructor
        Path myFile = Path.of(file);
        fileLength = (int) Files.lines(myFile).count();
        //reads in entire file line by line and stores each line as a string. Stores strings in a list of strings
        this.wholeFile = Files.readAllLines(myFile);
        //split file line into individual words by separation of comma (string of the columns)
        for (int i = 2; i < fileLength; i++) {
            this.splitFile = List.of((this.wholeFile.get(i).split(",")));

            String myDate = splitFile.get(1).replace("\"", "");
            this.year.add((Integer.parseInt(myDate)));

            String oneHundredthInchPrec = splitFile.get(10).replaceAll("\\s", "").replace("\"", "");
            if (!oneHundredthInchPrec.isEmpty() && !oneHundredthInchPrec.contains(" ")) {
                this.daysWithOneHundredthInchPrec.add(Integer.valueOf(oneHundredthInchPrec));
            } else {
                this.daysWithOneHundredthInchPrec.add(0);
            }

            String oneTenthInchPrec = splitFile.get(12).replaceAll("\\s", "").replace("\"", "");
            if (!oneTenthInchPrec.isEmpty() && !oneTenthInchPrec.contains(" ")) {
                this.daysWithOneTenthInchPrec.add(Integer.valueOf(oneTenthInchPrec));
            } else {
                this.daysWithOneTenthInchPrec.add(0);
            }

            String oneInchPrec = splitFile.get(14).replaceAll("\\s", "").replace("\"", "");
            if (!oneInchPrec.isEmpty() && !oneInchPrec.contains(" ")) {
                this.daysWithOneInchPrec.add(Integer.valueOf(oneInchPrec));
            } else {
                this.daysWithOneInchPrec.add(0);
            }

            String oneInchSnowDepth = splitFile.get(16).replaceAll("\\s", "").replace("\"", "");
            if (!oneInchSnowDepth.isEmpty() && !oneInchSnowDepth.contains(" ")) {
                this.daysWithOneInchSnowDepth.add(Integer.valueOf(oneInchSnowDepth));
            } else {
                this.daysWithOneInchSnowDepth.add(0);
            }

            String oneInchSnowFall = splitFile.get(18).replaceAll("\\s", "").replace("\"", "");
            if (!oneInchSnowFall.isEmpty() && !oneInchSnowFall.contains(" ")) {
                this.daysWithOneInchSnowFall.add(Integer.valueOf(oneInchSnowFall));
            } else {
                this.daysWithOneInchSnowFall.add(0);
            }

            String minTemp0 = splitFile.get(20).replaceAll("\\s", "").replace("\"", "");
            if (!minTemp0.isEmpty() && !minTemp0.contains(" ")) {
                this.daysWithMinTempLessOrEqual0.add(Integer.valueOf(minTemp0));
            } else {
                this.daysWithMinTempLessOrEqual0.add(0);
            }

            String minTemp32 = splitFile.get(22).replaceAll("\\s", "").replace("\"", "");
            if (!minTemp32.isEmpty() && !minTemp32.contains(" ")) {
                this.daysWithMinTempLessOrEqual32.add(Integer.valueOf(minTemp32));
            } else {
                this.daysWithMinTempLessOrEqual32.add(0);
            }

            String maxTemp32 = splitFile.get(24).replaceAll("\\s", "").replace("\"", "");
            if (!maxTemp32.isEmpty() && !maxTemp32.contains(" ")) {
                this.daysWithMaxTempLessOrEqual32.add(Integer.valueOf(maxTemp32));
            } else {
                this.daysWithMaxTempLessOrEqual32.add(0);
            }

            String maxTemp70 = splitFile.get(26).replaceAll("\\s", "").replace("\"", "");
            if (!maxTemp70.isEmpty() && !maxTemp70.contains(" ")) {
                this.daysWithMaxTempLessOrEqual70.add(Integer.valueOf(maxTemp70));
            } else {
                this.daysWithMaxTempLessOrEqual70.add(0);
            }

            String maxTemp90 = splitFile.get(28).replaceAll("\\s", "").replace("\"", "");
            if (!maxTemp90.isEmpty() && !maxTemp90.contains(" ")) {
                this.daysWithMinTempLessOrEqual90.add(Integer.valueOf(maxTemp90));
            } else {
                this.daysWithMinTempLessOrEqual90.add(0);
            }

            String fog = splitFile.get(30).replaceAll("\\s", "").replace("\"", "");
            if (!fog.isEmpty() && !fog.contains(" ")) {
                this.daysWithFog.add(Integer.valueOf(fog.replaceAll("\\s", "")));
            } else {
                this.daysWithFog.add(0);
            }

            String heavyFog = splitFile.get(31).replaceAll("\\s", "").replace("\"", "");
            if (!heavyFog.isEmpty() && !heavyFog.contains(" ")) {
                this.daysWithHeavyFog.add(Integer.valueOf(heavyFog.trim()));
            } else {
                this.daysWithHeavyFog.add(0);
            }

            String oneOrMoreStorm = splitFile.get(32).replaceAll("\\s", "").replace("\"", "");
            if (!oneOrMoreStorm.isEmpty() && !oneOrMoreStorm.contains(" ")) {
                this.daysWithOneOrMoreStorm.add(Integer.valueOf(oneOrMoreStorm));
            } else {
                //oneOrMoreStorm = oneOrMoreStorm.replaceAll("\\s", "");
                this.daysWithOneOrMoreStorm.add(0);
            }

            //String lowestTemp = splitFile.get(33).replaceAll("\\s","").replace("\"", "");
            //lowestTemp = lowestTemp.replaceAll("\\s", "");
            //if (!lowestTemp.isEmpty() && !lowestTemp.contains(" ")) {
            //this.lowestMinTempYear.add( Float.parseFloat(lowestTemp));
            //} else {
            //this.lowestMinTempYear.add(0.0f);
            //}

        }
    }

        public void setCategories() {
            dataCategories[0] = year;
            dataCategories[1] = daysWithOneHundredthInchPrec;
            dataCategories[2] = daysWithOneTenthInchPrec;
            dataCategories[3] = daysWithOneInchPrec;
            dataCategories[4] = daysWithOneInchSnowDepth;
            dataCategories[5] = daysWithOneInchSnowFall;
            dataCategories[6] = daysWithMinTempLessOrEqual0;
            dataCategories[7] = daysWithMinTempLessOrEqual32;
            dataCategories[8] = daysWithMaxTempLessOrEqual32;
            dataCategories[9] = daysWithMaxTempLessOrEqual70;
            dataCategories[10] = daysWithMinTempLessOrEqual90;
            dataCategories[11] = daysWithFog;
            dataCategories[12] = daysWithHeavyFog;
            dataCategories[13] = daysWithOneOrMoreStorm;
        }

        public List<Integer>[] getDataCatergories(){
            return dataCategories;
        };

    }