package jp.ac.uejobi.aruquest;

/**
 * Created by uejobi on 2018/11/12.
 */
import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SaveData {

    public void initialize(Context context, int rank, int[] weapon, int[] armor, int[] skill, int[][] item, int[] setWeapon, int[] setArmor, int[][] setSkill, int[][] setItem, int[] zokuseiID, int walkPoint, int[] sevenStep, int stepSum, int BGM, int SE, int[]date){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            context.openFileInput("json.txt")));
            JSONObject jsonObject;
            StringBuilder str = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line);
                str.append(System.getProperty("line.separator"));
            }
            try {
                jsonObject = new JSONObject(str.toString());
                jsonObject.getInt("rank");
                jsonObject.getJSONArray("weapon");
                jsonObject.getJSONArray("armor");
                jsonObject.getJSONArray("skill");
                jsonObject.getJSONArray("item");
                jsonObject.getJSONArray("setWeapon");
                jsonObject.getJSONArray("setArmor");
                jsonObject.getJSONArray("setSkill");
                jsonObject.getJSONArray("setItem");
                jsonObject.getJSONArray("zokuseiID");
                jsonObject.getInt("walkPoint");
                jsonObject.getJSONArray("sevenStep");
                jsonObject.getInt("stepSum");
                jsonObject.getInt("BGM");
                jsonObject.getInt("SE");
                jsonObject.getJSONArray("date");
            }catch (JSONException e){
                writing(context, rank, weapon,  armor, skill, item, setWeapon, setArmor, setSkill, setItem, zokuseiID, walkPoint, sevenStep, stepSum, BGM, SE, date);
            }
        } catch (IOException e) {
            writing(context, rank, weapon,  armor, skill, item, setWeapon, setArmor, setSkill, setItem, zokuseiID, walkPoint, sevenStep, stepSum, BGM, SE, date);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writing(Context context, int rank, int[] weapon, int[] armor, int[] skill, int[][] item, int[] setWeapon, int[] setArmor, int[][] setSkill, int[][] setItem, int[] zokuseiID, int walkPoint, int[] sevenStep, int stepSum, int BGM, int SE, int date[]) {
        JSONObject userobj = new JSONObject();
        try {
            JSONArray weaponArray = new JSONArray();
            for(int i = 0; i < weapon.length; i++){
                weaponArray.put(weapon[i]);
            }
            JSONArray armorArray = new JSONArray();
            for(int i = 0; i < armor.length; i++){
                armorArray.put(armor[i]);
            }
            JSONArray skillArray = new JSONArray();
            for(int i = 0; i < skill.length; i++){
                skillArray.put(skill[i]);
            }
            JSONArray itemArray = new JSONArray();
            for(int i = 0; i < item.length; i++){
                JSONObject jsonObject = new JSONObject();
                for(int j = 0; j < item[i].length; j++){
                    jsonObject.put("" + j, item[i][j]);
                }
                itemArray.put(jsonObject);
            }
            JSONArray setWeaponArray = new JSONArray();
            for(int i = 0; i < setWeapon.length; i++){
                setWeaponArray.put(setWeapon[i]);
            }
            JSONArray setArmorArray = new JSONArray();
            for(int i = 0; i < setArmor.length; i++){
                setArmorArray.put(setArmor[i]);
            }
            JSONArray setSkillArray = new JSONArray();
            for(int i = 0; i < setSkill.length; i++){
                JSONObject jsonObject = new JSONObject();
                for(int j = 0; j < setSkill[i].length; j++){
                    jsonObject.put("" + j, setSkill[i][j]);
                }
                setSkillArray.put(jsonObject);
            }
            JSONArray setItemArray = new JSONArray();
            for(int i = 0; i < setItem.length; i++){
                JSONObject jsonObject = new JSONObject();
                for(int j = 0; j < setItem[i].length; j++){
                    jsonObject.put("" + j, setItem[i][j]);
                }
                setItemArray.put(jsonObject);
            }
            JSONArray zokuseiIDArray = new JSONArray();
            for(int i = 0; i < zokuseiID.length; i++){
                zokuseiIDArray.put(zokuseiID[i]);
            }
            JSONArray sevenStepArray = new JSONArray();
            for(int i = 0; i < sevenStep.length; i++){
                sevenStepArray.put(sevenStep[i]);
            }
            JSONArray dateArray = new JSONArray();
            for(int i = 0; i < date.length; i++){
                dateArray.put(date[i]);
            }
            userobj.put("rank", rank);
            userobj.put("weapon", weaponArray);
            userobj.put("armor", armorArray);
            userobj.put("skill", skillArray);
            userobj.put("item", itemArray);
            userobj.put("setWeapon", setWeaponArray);
            userobj.put("setArmor", setArmorArray);
            userobj.put("setSkill", setSkillArray);
            userobj.put("setItem", setItemArray);
            userobj.put("zokuseiID", zokuseiIDArray);
            userobj.put("walkPoint", walkPoint);
            userobj.put("sevenStep", sevenStepArray);
            userobj.put("stepSum", stepSum);
            userobj.put("BGM", BGM);
            userobj.put("SE", SE);
            userobj.put("date", dateArray);
            String jsonString = userobj.toString();
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(
                        new OutputStreamWriter(
                                context.openFileOutput("json.txt", Context.MODE_PRIVATE)));
                writer.write(jsonString);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public int readRank(Context context){
        return reading(context, "rank");
    }

    public int[] readWeapon(Context context){
        return readingArray(context, "weapon");
    }

    public int[] readArmor(Context context){
        return readingArray(context, "armor");
    }

    public int[] readSkill(Context context){
        return readingArray(context, "skill");
    }

    public int[][] readItem(Context context){
        return readingTowArray(context, "item");
    }

    public int[] readSetWeapon(Context context){
        return readingArray(context, "setWeapon");
    }

    public int[] readSetArmor(Context context){
        return readingArray(context, "setArmor");
    }

    public int[][] readSetSkill(Context context){
        return readingTowArray(context, "setSkill");
    }

    public int[][] readSetItem(Context context){
        return readingTowArray(context, "setItem");
    }

    public int[] readZokuseiID(Context context){
        return readingArray(context, "zokuseiID");
    }

    public int readWalkPoint(Context context){
        return reading(context, "walkPoint");
    }

    public int[] readSevenStep(Context context){
        return readingArray(context, "sevenStep");
    }

    public int readWalkSum(Context context){
        return reading(context, "stepSum");
    }

    public int readBGM(Context context){
        return reading(context, "BGM");
    }

    public int readSE(Context context){
        return reading(context, "SE");
    }

    public int[] readDate(Context context){
        return readingArray(context, "date");
    }

    private int reading(Context context, String property) {
        BufferedReader reader = null;
        JSONObject jsonObject;
        StringBuilder str = new StringBuilder();
        int value = -1;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            context.openFileInput("json.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line);
                str.append(System.getProperty("line.separator"));
            }
            try {
                jsonObject = new JSONObject(str.toString());
                value = jsonObject.getInt(property);
            }catch (JSONException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    private int[] readingArray(Context context, String property) {
        BufferedReader reader = null;
        JSONObject jsonObject;
        JSONArray jsonArray;
        StringBuilder str = new StringBuilder();
        int[] value = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            context.openFileInput("json.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line);
                str.append(System.getProperty("line.separator"));
            }
            try {
                jsonObject = new JSONObject(str.toString());
                jsonArray = jsonObject.getJSONArray(property);
                value = new int[jsonArray.length()];
                for(int i = 0; i < jsonArray.length(); i++){
                    value[i] = jsonArray.getInt(i);
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

    private int[][] readingTowArray(Context context, String property) {
        BufferedReader reader = null;
        JSONObject jsonObject;
        JSONArray jsonArray;
        StringBuilder str = new StringBuilder();
        int[][] value = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(
                            context.openFileInput("json.txt")));
            String line;
            while ((line = reader.readLine()) != null) {
                str.append(line);
                str.append(System.getProperty("line.separator"));
            }
            try {
                jsonObject = new JSONObject(str.toString());
                jsonArray = jsonObject.getJSONArray(property);
                value = new int[jsonArray.length()][jsonArray.getJSONObject(0).length()];
                for(int i = 0; i < jsonArray.length(); i++){
                    for(int j = 0; j < jsonArray.getJSONObject(i).length(); j++) {
                        value[i][j] =jsonArray.getJSONObject(i).getInt(String.valueOf(j));
                    }
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

}

