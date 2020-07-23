package jp.ac.uejobi.aruquest;

/**
 * Created by uejobi on 2019/01/10.
 */

public class DataBlock1 {
    // [ダンジョンID[階層[縦ブロックID[横ブロックID]]]] 5
    int[][][][] blockid = {
            {{{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,398,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,600,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81},{81,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81},{81,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81},{81,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81},{81,81,81,81,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,81},{81,81,81,81,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,81},{81,81,81,81,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,0,0,0,81,81,81,0,0,0,0,0,0,81},{81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,0,141,0,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,0,143,0,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,0,143,0,81,81,81,81},{81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,0,141,0,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81},{81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81},{81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81},{81,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,0,0,0,0,0,0,0,0,0,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81}}},

            {{{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,154,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,601,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,0,141,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,141,0,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,81},{81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,0,0,0,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,0,0,0,0,0,0,81,81,0,143,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,0,143,0,0,0,0,0,81,81,81,81,81,81,81,81,81,0,0,0,0,0,0,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,0,0,0,0,0,0,0,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81},{81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,0,0,0,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81,81}},{{81,81,81,81,81,81,81,81,81},{81,81,81,81,398,81,81,81,81},{81,0,0,148,149,150,0,0,81},{81,0,0,151,152,153,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,0,0,0,0,81},{81,0,0,0,34,0,0,0,81},{81,81,81,81,81,81,81,81,81}}},

            {{{87,82,82,82,82,87,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,84,95,398,95,87,82,82,82,82,82,82,82,89,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,84},{83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,602,0,82,95,95,95,95,95,95,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,82,95,95,95,95,95,95,95,83,0,143,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{88,82,82,82,82,86,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85,95,146,95,86,82,82,84,95,95,95,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,95,0,0,0,0,0,0,83,95,95,95,95,86,82,82,82,82,82,82,82,82,82,82,82,84,0,0,0,83},{83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,23,0,0,0,0,0,0,83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,95,0,0,0,0,0,0,83,95,95,95,95,87,82,82,82,84,95,87,82,82,82,84,95,83,0,0,0,83},{83,0,0,0,87,82,82,82,82,82,82,82,84,0,0,0,87,82,82,82,82,82,82,82,84,0,0,0,83,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,83},{83,0,0,0,83,95,95,95,95,95,95,95,83,95,155,95,83,95,95,95,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,143,0,83,95,83,0,155,0,83,95,83,0,0,0,83},{83,0,0,0,83,95,87,82,82,82,82,82,85,0,0,0,86,82,82,82,82,82,82,82,85,0,0,0,83,95,87,82,82,85,0,0,0,86,82,85,0,0,0,86,82,85,95,22,95,83},{83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,146,95,83,95,83,0,0,0,87,82,84,95,146,95,87,82,82,82,82,82,82,82,83,0,0,0,83,95,83,0,0,0,87,82,82,82,82,84,0,0,0,87,82,82,82,82,82,90},{83,0,0,0,83,95,83,0,141,0,83,95,83,0,0,0,83,95,95,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,95,83},{83,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,83,95,87,82,82,82,84,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,95,83},{83,0,0,0,83,95,86,82,82,82,85,95,83,0,0,0,83,95,83,0,0,0,83,95,86,82,82,82,85,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,95,83},{83,0,0,0,83,95,95,95,95,95,95,95,83,0,0,0,83,95,83,0,141,0,83,95,95,95,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,95,83},{83,0,0,0,83,95,95,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,87,82,82,85,95,146,95,86,82,82,84,95,83,0,0,0,86,82,82,82,82,82,90},{83,0,0,0,83,95,95,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,83},{83,0,0,0,83,95,95,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,0,0,0,0,141,0,83,95,83,0,0,0,0,0,0,0,0,0,83},{83,0,0,0,86,82,82,82,82,82,84,95,83,0,0,0,83,95,83,95,22,95,86,82,82,82,82,85,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,87,82,82,82,82,82,85,95,86,82,82,82,82,82,84,0,0,0,83},{83,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,83,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,83,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,82,82,82,82,82,84,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,87,82,82,82,82,82,82,82,82,85,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,86,82,85,0,0,0,83,95,83,0,0,0,83,95,87,82,82,82,84,95,87,82,82,82,84,95,87,82,82,82,84,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,0,156,0,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,0,155,0,0,0,0,83,95,83,0,0,0,83,95,83,0,143,0,83,95,83,0,155,0,83,95,83,0,141,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,0,156,0,0,0,0,86,82,85,0,0,0,83,95,83,0,0,0,86,82,85,0,0,0,86,82,85,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,87,82,84,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,95,0,0,0,0,0,0,0,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,179,0,0,0,0,0,0,0,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,95,0,0,0,0,0,0,0,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,86,82,82,82,82,82,82,82,82,82,85,95,86,82,82,82,82,82,82,82,82,82,82,82,84,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,87,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,84,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,86,82,82,82,82,85,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,87,82,82,82,82,84,0,0,0,87,82,82,82,82,84,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,83,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,83,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,86,82,85,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,86,82,82,82,82,82,82,82,82,84,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,0,0,0,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,0,0,0,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83},{83,95,95,95,95,95,83,0,0,0,0,0,0,0,0,0,83,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,86,82,82,82,82,82,82,82,82,82,82,85,0,0,0,83},{83,95,95,95,95,95,86,82,82,82,82,82,82,82,82,82,85,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,95,83,0,0,0,83,95,95,95,95,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83},{83,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85,0,0,0,86,82,82,82,82,91,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85}}},

            {{{87,82,82,82,82,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,84,95,154,95,87,89,82,82,82,82,82,82,82,82,82,89,89,89,89,89,89,89,89,89,89,89,89,82,84},{83,87,82,82,84,83,83,83,83,83,83,83,83,83,83,83,83,83,83,83,83,83,0,603,0,83,83,0,0,0,0,95,0,0,0,143,83,88,91,91,91,91,91,91,91,91,91,91,84,83},{83,83,87,89,90,83,83,83,83,83,83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,0,0,0,0,179,0,0,0,0,83,83,0,0,0,0,0,0,0,0,0,0,83,83},{83,83,83,83,86,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,85,0,0,0,83,83,0,0,0,0,95,0,0,0,0,83,83,0,0,0,0,0,0,0,0,0,0,83,83},{83,83,83,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,0,0,0,0,89,0,0,0,0,83,83,0,0,0,0,0,0,0,0,0,0,83,83},{83,83,83,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,0,0,0,0,83,0,0,0,0,83,83,0,0,0,87,82,82,84,0,0,0,83,83},{83,83,83,83,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,0,0,0,0,155,0,0,0,0,83,83,0,0,0,88,82,82,90,0,0,0,83,83},{83,83,83,83,0,0,0,87,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85,83,0,0,0,0,83,0,0,0,0,83,83,0,0,0,88,82,82,90,0,0,0,83,83},{83,83,83,83,0,0,0,88,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,87,91,84,0,0,0,83,83,0,0,0,88,82,82,90,0,0,0,83,83},{83,83,83,83,0,0,0,88,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85,95,22,95,88,82,90,95,22,95,86,91,82,155,82,91,82,82,85,0,0,0,83,83},{83,83,83,83,0,0,0,86,82,82,82,82,82,82,82,89,89,89,89,84,0,0,0,0,0,0,0,0,0,0,88,82,90,0,0,0,0,0,0,0,0,0,0,0,95,0,0,0,83,83},{83,83,83,83,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,0,0,0,0,0,0,0,0,0,0,88,82,90,0,0,0,0,0,0,0,0,0,0,0,179,0,0,0,83,83},{83,83,83,83,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,0,0,0,0,0,0,0,0,0,0,88,82,90,0,0,0,0,0,0,0,0,0,0,0,95,0,0,0,83,83},{83,83,83,83,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,0,0,0,87,89,82,82,82,82,82,91,82,91,82,82,82,82,82,82,82,82,82,82,82,84,0,0,0,83,83},{83,83,83,83,87,89,89,89,89,89,89,84,0,0,0,86,91,91,91,85,0,0,0,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,82,89,89,89,89,84,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,95,0,0,0,0,0,0,0,83,0,0,0,0,0,95,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,179,0,0,0,0,0,0,0,155,0,0,0,0,0,23,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,95,0,0,0,0,0,141,95,0,95,0,0,0,0,95,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,87,89,89,89,89,89,84,143,0,0,95,146,95,87,89,89,89,89,89,89,84,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,0,0,0,0,0,0,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,0,0,0,0,0,0,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,0,0,0,0,0,0,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,95,22,95,87,89,84,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,83,83,83,83,83,0,0,0,83,83,83,83,83,83,0,0,0,83,83},{83,83,83,83,83,88,91,91,91,91,91,85,95,146,95,86,91,91,91,91,91,85,0,0,0,83,83,83,83,83,83,83,83,83,83,83,0,0,0,86,91,85,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,0,0,0,0,0,95,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,83,83,83,83,83,0,0,0,0,0,0,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,0,0,0,0,0,179,0,0,0,0,0,0,0,0,0,0,0,0,0,83,86,91,91,91,91,91,91,91,91,90,0,0,0,0,0,0,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,0,0,0,0,0,95,0,0,0,0,0,0,0,0,0,0,0,0,0,86,82,82,82,82,82,82,82,82,82,90,0,0,0,0,0,0,83,83,83,0,0,0,83,83},{83,83,83,83,83,83,95,22,95,95,0,95,95,22,95,87,89,89,89,89,89,89,82,82,82,82,82,82,82,82,82,82,82,82,82,85,95,146,95,95,155,82,91,91,85,0,0,0,83,83},{83,83,83,83,83,83,141,0,0,95,0,95,0,0,0,83,83,83,83,83,83,87,82,82,82,82,82,82,82,82,82,82,82,82,82,84,0,0,0,0,0,0,0,0,95,0,0,0,83,83},{83,83,83,83,83,83,0,0,0,0,155,0,0,0,0,83,83,83,83,83,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,0,0,0,0,0,23,0,0,0,83,83},{83,83,83,83,83,83,0,0,0,87,91,84,0,0,0,83,83,83,83,83,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,0,0,0,0,0,95,0,0,0,83,83},{83,83,83,83,83,83,0,0,0,88,82,90,0,0,0,83,83,83,83,83,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,87,89,89,89,89,89,89,89,89,90,83},{83,83,83,83,83,83,0,0,0,83,95,83,0,0,0,83,83,83,83,83,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,0,0,0,86,82,85,0,0,0,83,83,83,83,83,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,0,0,0,0,95,0,0,0,0,83,83,83,83,83,83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,0,0,0,0,179,0,0,0,0,83,83,83,83,83,83,91,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,0,0,0,0,95,0,0,0,0,83,86,91,91,91,91,82,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,87,89,89,89,84,87,82,82,82,91,82,82,82,82,82,89,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,83,83,83,83,83,88,82,82,82,82,82,82,82,82,82,91,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,83,83,83,83,83,88,82,82,82,82,82,82,82,82,82,89,82,82,82,82,82,82,82,82,82,82,82,82,82,85,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,83,83,83,83,83,88,82,82,82,82,82,82,82,82,82,90,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,83,83,83,83,83,88,82,82,82,82,82,82,82,82,82,90,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,83,83,83,83,83,88,82,82,82,82,82,82,82,82,82,90,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,83,83,83,83,83,83,83,83,83,83,83},{83,83,83,83,83,83,83,83,83,83,83,88,82,82,82,82,82,82,82,82,82,90,0,0,0,87,82,82,82,82,82,82,82,82,82,82,82,82,82,91,91,91,91,91,91,91,91,85,83,83},{83,83,86,91,91,91,91,91,91,91,91,86,82,82,82,82,82,82,82,82,82,90,0,0,0,88,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,84,83,83},{83,86,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,90,0,0,0,88,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,91,85,83},{86,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85,00,0,86,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,85}},{{87,82,82,89,82,89,82,82,84},{88,82,82,85,398,86,82,82,90},{83,0,0,731,732,733,0,0,83},{83,0,0,734,735,736,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,0,0,0,0,83},{83,0,0,0,34,0,0,0,83},{86,82,82,82,82,82,82,82,85}}},

            {{{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,96,398,96,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,604,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,141,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,96,302,96,92,92,92,92,92,92,92,92,92,92,92,92},{92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,302,96,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,158,0,92,92,92,92,92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92,0,158,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,0,0,0,0,141,0,92,92,92,92,0,141,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,92,92,92,92,0,0,0,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,0,143,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,96,302,96,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,0,0,0,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,92,92,92,96,302,96,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,0,0,0,92,92,92,92,92,92,92,92,92},{92,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,158,0,92,92,0,0,0,0,0,0,0,0,0,0,92,92},{92,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,92,92,0,0,0,0,0,0,0,0,158,0,92,92},{92,0,0,0,0,0,0,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,0,0,0,0,0,0,0,92,92},{92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,0,143,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92},{92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,0,0,0,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92}}},    };
    public int[][] blockidR(int id, int kai) {
        return blockid[id][kai];
        // ブロックID＊ｘ
    }
}