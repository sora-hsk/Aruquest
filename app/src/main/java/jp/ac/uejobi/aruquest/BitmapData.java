package jp.ac.uejobi.aruquest;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by uejobi on 2018/11/28.
 */

public class BitmapData {
    // ブロックは１～２０が背景、２１～８０が当たり判定無しブロック、８１～１４０が当たり判定があるブロック、１４１～がオブジェクト
    Bitmap[] block = new Bitmap[800];
    Bitmap bitmap;

    public void setBlockBitmap(Resources resources, int width, int height){
        block[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block1), width, height,false);
        block[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block2), width, height,false);
        block[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block3), width, height,false);
        block[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block4), width, height,false);
        block[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block5), width, height,false);
        block[6] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block6), width, height,false);
        block[7] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block7), width, height,false);
        block[8] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block8), width, height,false);
        block[9] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block9), width, height,false);
        block[21] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block21), width, height,false);
        block[22] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block22), width, height,false);
        block[23] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block23), width, height,false);
        block[25] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block25), width, height,false);
        block[26] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block26), width, height,false);
        block[27] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block27), width, height,false);
        block[28] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block28), width, height,false);
        block[29] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block29), width, height,false);
        block[30] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block30), width, height,false);
        block[34] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block34), width, height,false);
        block[36] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block36), width, height,false);
        block[81] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block81), width, height,false);
        block[82] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block82), width, height,false);
        block[83] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block83), width, height,false);
        block[84] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block84), width, height,false);
        block[85] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block85), width, height,false);
        block[86] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block86), width, height,false);
        block[87] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block87), width, height,false);
        block[88] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block88), width, height,false);
        block[89] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block89), width, height,false);
        block[90] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block90), width, height,false);
        block[91] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block91), width, height,false);
        block[92] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block92), width, height,false);
        block[93] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block93), width, height,false);
        block[94] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block94), width, height,false);
        block[95] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block95), width, height,false);
        block[96] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block96), width, height,false);
        block[97] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block97), width, height,false);
        block[98] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block98), width, height,false);
        block[99] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block99), width, height,false);
        block[111] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block111), width, height,false);
        block[112] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block112), width, height,false);
        block[113] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block113), width, height,false);
        block[114] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block114), width, height,false);
        block[115] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block115), width, height,false);
        block[141] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block141), width, height,false);
        block[142] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block142), width, height,false);
        block[143] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block143), width, height,false);
        block[144] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block144), width, height,false);
        block[145] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block145), width, height,false);
        block[146] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block146), width, height,false);
        block[147] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block147), width, height,false);
        block[148] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block148), width, height,false);
        block[149] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block149), width, height,false);
        block[150] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block150), width, height,false);
        block[151] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block151), width, height,false);
        block[152] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block152), width, height,false);
        block[153] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block153), width, height,false);
        block[154] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block154), width, height,false);
        block[155] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block155), width, height,false);
        block[156] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block156), width, height,false);
        block[157] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block157), width, height,false);
        block[158] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block158), width, height,false);
        block[159] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block159), width, height,false);
        block[161] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block161), width, height,false);
        block[162] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block162), width, height,false);
        block[163] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block163), width, height,false);
        block[164] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block164), width, height,false);
        block[165] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block165), width, height,false);
        block[166] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block166), width, height,false);
        block[167] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block167), width, height,false);
        block[168] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block168), width, height,false);
        block[169] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block169), width, height,false);
        block[171] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block171), width, height,false);
        block[179] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block179), width, height,false);
        block[181] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block181), width, height,false);
        block[182] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block182), width, height,false);
        block[183] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block183), width, height,false);
        block[185] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block185), width, height,false);
        block[186] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block186), width, height,false);
        block[187] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block187), width, height,false);
        block[188] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block188), width, height,false);
        block[189] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block189), width, height,false);
        block[191] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block191), width, height,false);
        block[192] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block192), width, height,false);
        block[193] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block193), width, height,false);
        block[194] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block194), width, height,false);
        block[195] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block195), width, height,false);
        block[196] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block196), width, height,false);
        block[197] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block197), width, height,false);
        block[198] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block198), width, height,false);
        block[199] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block199), width, height,false);
        block[211] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block211), width, height,false);
        block[212] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block212), width, height,false);
        block[213] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block213), width, height,false);
        block[214] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block214), width, height,false);
        block[215] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block215), width, height,false);
        block[216] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block216), width, height,false);
        block[349] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block349), width, height,false);
        block[600] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block600), width, height,false);
        block[601] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block601), width, height,false);
        block[602] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block602), width, height,false);
        block[603] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block603), width, height,false);
        block[604] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block604), width, height,false);
        block[605] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block605), width, height,false);
        block[606] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block606), width, height,false);
        block[607] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block607), width, height,false);
        block[608] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block608), width, height,false);
        block[609] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block609), width, height,false);
        block[610] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block610), width, height,false);
        block[611] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block611), width, height,false);
        block[612] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block612), width, height,false);
        block[613] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block613), width, height,false);
        block[614] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block614), width, height,false);
        block[615] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block615), width, height,false);
        block[616] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block616), width, height,false);
        block[617] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block617), width, height,false);
        block[618] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block618), width, height,false);
        block[700] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block700), width, height,false);
        block[701] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block701), width, height,false);
        block[702] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block702), width, height,false);
        block[703] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block703), width, height,false);
        block[704] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block704), width, height,false);
        block[705] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block705), width, height,false);
        block[707] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block707), width, height,false);
        block[708] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block708), width, height,false);
        block[709] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block709), width, height,false);
        block[710] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block710), width, height,false);
        block[711] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block711), width, height,false);
        block[712] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block712), width, height,false);
        block[713] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block713), width, height,false);
        block[714] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block714), width, height,false);
        block[715] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block715), width, height,false);
        block[716] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block716), width, height,false);
        block[717] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block717), width, height,false);
        block[718] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block718), width, height,false);
        block[719] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block719), width, height,false);
        block[720] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block720), width, height,false);
        block[721] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block721), width, height,false);
        block[722] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block722), width, height,false);
        block[723] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block723), width, height,false);
        block[724] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block724), width, height,false);
        block[725] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block725), width, height,false);
        block[726] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block726), width, height,false);
        block[727] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block727), width, height,false);
        block[728] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block728), width, height,false);
        block[729] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block729), width, height,false);
        block[730] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block730), width, height,false);
        block[731] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block731), width, height,false);
        block[732] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block732), width, height,false);
        block[733] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block733), width, height,false);
        block[734] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block734), width, height,false);
        block[735] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block735), width, height,false);
        block[736] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block736), width, height,false);
        block[737] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block737), width, height,false);
        block[738] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block738), width, height,false);
        block[739] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block739), width, height,false);
        block[740] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block740), width, height,false);
        block[741] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block741), width, height,false);
        block[742] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block742), width, height,false);
        block[743] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block743), width, height,false);
        block[744] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block744), width, height,false);
        block[745] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block745), width, height,false);
        block[746] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block746), width, height,false);
        block[747] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block747), width, height,false);
        block[748] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block748), width, height,false);
        block[749] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block749), width, height,false);
        block[750] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block750), width, height,false);
        block[751] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block751), width, height,false);
        block[752] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block752), width, height,false);
        block[753] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block753), width, height,false);
        block[754] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block754), width, height,false);
        block[755] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block755), width, height,false);
        block[756] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block756), width, height,false);
        block[757] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.block757), width, height,false);


    }

    public Bitmap getBlockBitmap(int blockID){
        if(blockID != 0){
            switch (blockID){
                case 310:
                    return block[141];
                case 396:
                    return block[141];
                case 397:
                    return block[141];
                case 300:
                    return block[144];
                case 301:
                    return block[144];
                case 302:
                    return block[144];
                case 351:
                    return block[181];
                case 352:
                    return block[181];
                case 353:
                    return block[181];
                case 354:
                    return block[181];
                case 355:
                    return block[181];
                case 357:
                    return block[181];
                case 398:
                    return block[154];
                case 450:
                    return block[181];
                case 528:
                    return block[154];
                case 529:
                    return block[154];
                case 531:
                    return block[154];
                case 532:
                    return block[154];
                case 533:
                    return block[154];
                case 534:
                    return block[34];
                case 535:
                    return block[154];
                case 536:
                    return block[154];
                case 537:
                    return block[154];
                case 538:
                    return block[154];
                case 539:
                    return block[154];
                case 541:
                    return block[154];
                case 542:
                    return block[154];
                case 543:
                    return block[154];
                case 544:
                    return block[154];
                case 545:
                    return block[154];
                case 546:
                    return block[154];
                case 547:
                    return block[154];
                case 548:
                    return block[154];
                case 549:
                    return block[154];
                case 400:
                    return block[185];
                case 401:
                    return block[185];
                case 402:
                    return block[185];
                case 403:
                    return block[185];
                case 404:
                    return block[185];
                case 405:
                    return block[185];
                case 399:
                    return block[186];
                case 37:
                    return block[36];
                case 43:
                    return block[115];
                case 44:
                    return block[115];
                case 40:
                    return block[22];
                case 41:
                    return block[22];
                case 42:
                    return block[22];
                case 45:
                    return block[22];
                case 46:
                    return block[22];
                case 47:
                    return block[22];
                case 48:
                    return block[22];
                case 49:
                    return block[22];
                case 50:
                    return block[22];
                case 51:
                    return block[22];
                case 52:
                    return block[22];
                case 53:
                    return block[22];
            }
            return block[blockID];
        }
        return null;
    }

    public Bitmap getEnemyBitmap(int enemyID, Resources resources, int width, int height){
        switch (enemyID){
            case 0:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy0), width, height,false);
            case 1:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy1), width, height,false);
            case 2:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy2), width, height,false);
            case 3:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy3), width, height,false);
            case 4:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy4), width, height,false);
            case 5:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy5), width, height,false);
            case 6:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy6), width, height,false);
            case 7:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy7), width, height,false);
            case 8:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy8), width, height,false);
            case 9:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy9), width, height,false);
            case 10:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy10), width, height,false);
            case 11:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy11), width, height,false);
            case 12:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy12), width, height,false);
            case 13:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy13), width, height,false);
            case 14:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy14), width, height,false);
            case 15:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy15), width, height,false);
            case 16:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy16), width, height,false);
            case 17:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy17), width, height,false);
            case 18:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy18), width, height,false);
            case 19:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy19), width, height,false);
            case 20:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy20), width, height,false);
            case 21:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy21), width, height,false);
            case 22:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy22), width, height,false);
            case 23:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy23), width, height,false);
            case 24:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy24), width, height,false);
            case 25:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy25), width, height,false);
            case 26:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy26), width, height,false);
            case 27:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy27), width, height,false);
            case 28:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy28), width, height,false);
            case 29:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy29), width, height,false);
            case 30:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy30), width, height,false);
            case 31:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy31), width, height,false);
            case 32:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy32), width, height,false);
            case 33:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy33), width, height,false);
            case 34:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy34), width, height,false);
            case 35:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy35), width, height,false);
            case 36:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy36), width, height,false);
            case 37:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy37), width, height,false);
            case 38:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy38), width, height,false);
            case 39:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy39), width, height,false);
            case 40:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy40), width, height,false);
            case 41:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy41), width, height,false);
            case 42:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy42), width, height,false);
            case 43:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy43), width, height,false);
            case 44:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy44), width, height,false);
            case 45:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy45), width, height,false);
            case 46:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy46), width, height,false);
            case 47:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy47), width, height,false);
            case 48:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy48), width, height,false);
            case 49:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy49), width, height,false);
            case 50:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy50), width, height,false);
            case 51:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy51), width, height,false);
            case 52:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy52), width, height,false);
            case 53:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy53), width, height,false);
            case 54:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy54), width, height,false);
            case 55:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy55), width, height,false);
            case 56:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy56), width, height,false);
            case 57:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy57), width, height,false);
            case 58:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy58), width, height,false);
            case 59:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy60), width, height,false);
            case 60:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy59), width, height,false);
            case 61:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy62), width, height,false);
            case 62:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy61), width, height,false);
            case 63:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy63), width, height,false);
            case 64:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy64), width, height,false);
            case 65:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy65), width, height,false);
            case 66:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy66), width, height,false);
            case 67:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy67), width, height,false);
            case 68:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy68), width, height,false);
            case 69:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy69), width, height,false);
            case 70:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy70), width, height,false);
            case 71:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy71), width, height,false);
            case 72:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy72), width, height,false);
            case 73:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy73), width, height,false);
            case 74:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy74), width, height,false);
            case 75:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.enemy75), width, height,false);
        }
        return null;
    }

    public Bitmap getWeaponBitmap(int bitmapID, Resources resources, int width, int height){
        switch (bitmapID){
            case 0:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon0), width, height,false);
            case 1:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon1), width, height,false);
            case 2:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon2), width, height,false);
            case 3:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon3), width, height,false);
            case 4:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon4), width, height,false);
            case 5:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon5), width, height,false);
            case 6:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon6), width, height,false);
            case 7:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon7), width, height,false);
            case 8:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon8), width, height,false);
            case 9:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon9), width, height,false);
            case 10:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon10), width, height,false);
            case 11:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon11), width, height,false);
            case 12:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon12), width, height,false);
            case 13:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon13), width, height,false);
            case 14:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon14), width, height,false);
            case 15:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon15), width, height,false);
            case 16:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon16), width, height,false);
            case 17:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon17), width, height,false);
            case 18:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon18), width, height,false);
            case 19:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon19), width, height,false);
            case 20:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon20), width, height,false);
            case 21:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon21), width, height,false);
            case 22:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon22), width, height,false);
            case 23:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon23), width, height,false);
            case 24:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon24), width, height,false);
            case 25:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon25), width, height,false);
            case 26:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon26), width, height,false);
            case 27:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon27), width, height,false);
            case 28:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon28), width, height,false);
            case 29:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon29), width, height,false);
            case 30:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon30), width, height,false);
            case 31:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon31), width, height,false);
            case 32:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon32), width, height,false);
            case 33:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon33), width, height,false);
            case 34:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon34), width, height,false);
            case 35:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon35), width, height,false);
            case 36:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon36), width, height,false);
            case 37:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon37), width, height,false);
            case 38:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon38), width, height,false);
            case 39:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon39), width, height,false);
            case 40:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon40), width, height,false);
            case 41:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon41), width, height,false);
            case 42:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon42), width, height,false);
            case 43:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon43), width, height,false);
            case 44:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon44), width, height,false);
            case 45:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon45), width, height,false);
            case 46:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon46), width, height,false);
            case 47:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon47), width, height,false);
            case 48:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon48), width, height,false);
            case 49:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon49), width, height,false);
            case 50:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon50), width, height,false);
            case 51:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon51), width, height,false);
            case 52:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon52), width, height,false);
            case 53:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon53), width, height,false);
            case 54:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon54), width, height,false);
            case 55:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon55), width, height,false);
            case 56:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon56), width, height,false);
            case 57:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon57), width, height,false);
            case 58:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon58), width, height,false);
            case 59:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon59), width, height,false);
            case 60:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon60), width, height,false);
            case 61:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon61), width, height,false);
            case 62:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon62), width, height,false);
            case 63:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon63), width, height,false);
            case 64:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon64), width, height,false);
            case 65:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon65), width, height,false);
            case 66:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon66), width, height,false);
            case 67:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon67), width, height,false);
            case 68:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon68), width, height,false);
            case 69:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon69), width, height,false);
            case 70:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon70), width, height,false);
            case 71:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon71), width, height,false);
            case 72:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon72), width, height,false);
            case 73:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon73), width, height,false);
            case 74:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon74), width, height,false);
            case 75:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon75), width, height,false);
            case 76:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon76), width, height,false);
            case 77:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon77), width, height,false);
            case 78:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon78), width, height,false);
            case 79:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon79), width, height,false);
            case 80:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon80), width, height,false);
            case 81:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon81), width, height,false);
            case 82:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon82), width, height,false);
            case 83:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon83), width, height,false);
            case 84:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon84), width, height,false);
            case 85:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon85), width, height,false);
            case 86:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon86), width, height,false);
            case 87:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon87), width, height,false);
            case 88:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon88), width, height,false);
            case 89:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon89), width, height,false);
            case 90:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon90), width, height,false);
            case 91:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon91), width, height,false);
            case 92:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon92), width, height,false);
            case 93:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon93), width, height,false);
            case 94:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon94), width, height,false);
            case 95:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon95), width, height,false);
            case 96:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon96), width, height,false);
            case 97:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon97), width, height,false);
            case 98:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon98), width, height,false);
            case 99:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon99), width, height,false);
            case 100:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon100), width, height,false);
            case 101:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon101), width, height,false);
            case 102:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon102), width, height,false);
            case 103:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon103), width, height,false);
            case 104:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon104), width, height,false);
            case 105:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon105), width, height,false);
            case 106:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon106), width, height,false);
            case 107:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon107), width, height,false);
            case 108:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.weapon108), width, height,false);






        }
        return null;
    }

    public Bitmap getArmorBitmap(int armorID, Resources resources, int width, int height){
        switch (armorID){
            case 0:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor000), width, height,false);
            case 1:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor001), width, height,false);
            case 2:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor002), width, height,false);
            case 3:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor003), width, height,false);
            case 4:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor004), width, height,false);
            case 5:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor005), width, height,false);
            case 6:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor006), width, height,false);
            case 7:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor007), width, height,false);
            case 8:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor008), width, height,false);
            case 9:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor009), width, height,false);
            case 10:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor010), width, height,false);
            case 11:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor011), width, height,false);
            case 12:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor012), width, height,false);
            case 13:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor013), width, height,false);
            case 14:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor014), width, height,false);
            case 15:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor015), width, height,false);
            case 16:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor016), width, height,false);
            case 17:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor017), width, height,false);
            case 18:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor018), width, height,false);
            case 19:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor019), width, height,false);
            case 20:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor020), width, height,false);
            case 21:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor021), width, height,false);
            case 22:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor022), width, height,false);
            case 23:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor023), width, height,false);
            case 24:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor024), width, height,false);
            case 25:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor025), width, height,false);
            case 26:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor026), width, height,false);
            case 27:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor027), width, height,false);
            case 28:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor028), width, height,false);
            case 29:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor029), width, height,false);
            case 30:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor030), width, height,false);
            case 31:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor031), width, height,false);
            case 32:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor032), width, height,false);
            case 33:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor033), width, height,false);
            case 34:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor034), width, height,false);
            case 35:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor035), width, height,false);
            case 36:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor036), width, height,false);
            case 37:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor037), width, height,false);
            case 38:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor038), width, height,false);
            case 39:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor039), width, height,false);
            case 40:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor040), width, height,false);
            case 41:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor041), width, height,false);
            case 42:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor042), width, height,false);
            case 43:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor043), width, height,false);
            case 44:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor044), width, height,false);
            case 45:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor045), width, height,false);
            case 46:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor046), width, height,false);
            case 47:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor047), width, height,false);
            case 48:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor048), width, height,false);
            case 49:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor049), width, height,false);
            case 50:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor050), width, height,false);
            case 51:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor051), width, height,false);
            case 52:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor052), width, height,false);
            case 53:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor053), width, height,false);
            case 54:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor054), width, height,false);
            case 55:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor055), width, height,false);
            case 56:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor056), width, height,false);
            case 57:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor057), width, height,false);
            case 58:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor058), width, height,false);
            case 59:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor059), width, height,false);
            case 60:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor060), width, height,false);
            case 61:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor061), width, height,false);
            case 62:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor062), width, height,false);
            case 63:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor063), width, height,false);
            case 64:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor064), width, height,false);
            case 65:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor065), width, height,false);
            case 66:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor066), width, height,false);
            case 67:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor067), width, height,false);
            case 68:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor068), width, height,false);
            case 69:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor069), width, height,false);
            case 70:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor070), width, height,false);
            case 71:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor071), width, height,false);
            case 72:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor072), width, height,false);
            case 73:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor073), width, height,false);
            case 74:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor074), width, height,false);
            case 75:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor075), width, height,false);
            case 76:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor076), width, height,false);
            case 77:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor077), width, height,false);
            case 78:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor078), width, height,false);
            case 79:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor079), width, height,false);
            case 80:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor080), width, height,false);
            case 81:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor081), width, height,false);
            case 82:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor082), width, height,false);
            case 83:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor083), width, height,false);
            case 84:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor084), width, height,false);
            case 85:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor085), width, height,false);
            case 86:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor086), width, height,false);
            case 87:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor087), width, height,false);
            case 88:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor088), width, height,false);
            case 89:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor089), width, height,false);
            case 90:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor090), width, height,false);
            case 91:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor091), width, height,false);
            case 92:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor092), width, height,false);
            case 93:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor093), width, height,false);
            case 94:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor094), width, height,false);
            case 95:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor095), width, height,false);
            case 96:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor096), width, height,false);
            case 97:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor097), width, height,false);
            case 98:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor098), width, height,false);
            case 99:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor099), width, height,false);
            case 100:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor100), width, height,false);
            case 101:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor101), width, height,false);
            case 102:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor102), width, height,false);
            case 103:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor103), width, height,false);
            case 104:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor104), width, height,false);
            case 105:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor105), width, height,false);
            case 106:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor106), width, height,false);
            case 107:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.armor107), width, height,false);
        }
        return null;
    }

    public Bitmap getItemBitmap(int itemID, Resources resources, int width, int height){
        switch (itemID){
            case 0:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item0), width, height,false);
            case 1:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item1), width, height,false);
            case 2:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item2), width, height,false);
            case 3:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item3), width, height,false);
            case 4:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item4), width, height,false);
            case 5:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item5), width, height,false);
            case 6:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item6), width, height,false);
            case 7:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item7), width, height,false);
            case 8:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item8), width, height,false);
            case 9:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item9), width, height,false);
            case 10:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item10), width, height,false);
            case 11:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item11), width, height,false);
            case 12:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item12), width, height,false);
            case 13:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item13), width, height,false);
            case 14:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item14), width, height,false);
            case 15:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item15), width, height,false);
            case 16:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item16), width, height,false);
            case 17:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item17), width, height,false);
            case 18:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item18), width, height,false);
            case 19:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item19), width, height,false);
            case 20:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item20), width, height,false);
            case 21:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item21), width, height,false);
            case 22:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item22), width, height,false);
            case 23:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item23), width, height,false);
            case 24:
                return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(resources, R.drawable.item24), width, height,false);
       }
        return null;
    }
}
