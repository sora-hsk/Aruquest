package jp.ac.uejobi.aruquest;

/**
 * Created by uejobi on 2019/01/10.
 */

public class DataBlock6 {
    // [ダンジョンID[階層[縦ブロックID[横ブロックID]]]] 3
    int[][][][] blockid = {
            {{{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,154,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,112,144,112,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,616,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,617,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,212,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,0,0,618,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,615,0,0,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113},{113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,0,0,0,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113,113}}, {{113,113,113,113,113,113,113,113,113},{113,113,113,113,398,113,113,113,113},{113,0,0,725,726,727,0,0,113},{113,0,0,728,729,730,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,0,0,0,0,113},{113,0,0,0,34,0,0,0,113},{113,113,113,113,113,113,113,113,113}}},

            {{{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,398,114,114,114,114,114,114,114},{114,114,114,0,0,0,737,738,739,0,0,0,114,114,114},{114,114,114,0,0,0,740,741,742,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,0,0,0,28,29,30,0,0,0,114,114,114},{114,114,114,114,114,114,25,26,27,114,114,114,114,114,114},{114,114,114,114,114,114,25,26,27,114,114,114,114,114,114},{114,114,114,114,114,114,25,26,27,114,114,114,114,114,114},{114,114,114,114,114,114,25,26,27,114,114,114,114,114,114},{114,114,114,114,114,114,25,26,27,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,28,29,30,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114},{114,114,114,114,114,114,114,114,114,114,114,114,114,114,114}}},

            {{{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,398,115,115,115,115,115,115,115},{115,115,115,0,0,115,45,46,47,115,0,0,115,115,115},{115,115,115,0,0,115,48,49,50,115,0,0,115,115,115},{115,115,115,0,0,115,51,52,53,115,0,0,115,115,115},{115,115,115,0,0,115,40,41,42,115,0,0,115,115,115},{115,115,115,0,0,115,43,349,44,115,0,0,115,115,115},{115,115,115,0,0,0,0,0,0,0,0,0,115,115,115},{115,115,115,0,0,0,0,0,0,0,0,0,115,115,115},{115,115,115,0,0,0,0,0,0,0,0,0,115,115,115},{115,115,115,0,0,0,0,0,0,0,0,0,115,115,115},{115,115,115,0,0,0,0,0,0,0,0,0,115,115,115},{115,115,115,0,0,0,0,0,0,0,0,0,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,0,0,0,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},{115,115,115,115,115,115,115,115,115,115,115,115,115,115,115},}}
    };

    public int[][] blockidR(int id, int kai) {
        return blockid[id - 15][kai];
        // ブロックID＊ｘ
    }
}
