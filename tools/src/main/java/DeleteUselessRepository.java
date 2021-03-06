import java.io.File;

public class DeleteUselessRepository {
    private static String MAVEN_PATH = "/Users/panguanghua/.m2/repository";

    /**
     * 判断是否存在jar
     *
     * @param file
     * @return
     * @author xfcyzq
     * @version 1.0
     */
    private static boolean judge(File file) {
        boolean isHaveJar = false;
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File _file : files) {
                if (_file.getName().endsWith(".jar")) {
                    isHaveJar = true;
                }
                if (_file.isDirectory()) {
                    boolean isNextHaveJar = judge(_file);
                    if (isNextHaveJar) {
                        isHaveJar = true;
                    }
                }
            }
        }
        if (!isHaveJar) {
//            System.out.println(file.getPath() + file.getName());
            delete(file);
        }
        return isHaveJar;
    }

    /**
     * 删除操作
     *
     * @param file
     * @author xfcyzq
     * @version 1.0
     */
    public static void delete(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isDirectory()) {
                    delete(f);
                }
                f.delete();
                System.out.println("已删除：" + f.getAbsolutePath());
            }
        } else {
            file.delete();
            System.out.println("已删除：" + file.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        String nums = "6225570450\n" +
                "6225570457\n" +
                "6225570466\n" +
                "6225570475\n" +
                "6225570483\n" +
                "6225570488\n" +
                "6225570497\n" +
                "6225570512\n" +
                "6225570523\n" +
                "6225570528\n" +
                "6225570539\n" +
                "6225570544\n" +
                "6225570547\n" +
                "6225570555\n" +
                "6225570561\n" +
                "6225570569\n" +
                "6225570577\n" +
                "6225570585\n" +
                "6225570593\n" +
                "6225570595\n" +
                "6225570600\n" +
                "6225570618\n" +
                "6225570627\n" +
                "6225570633\n" +
                "6225570648\n" +
                "6225570657\n" +
                "6225570666\n" +
                "6225570673\n" +
                "6225570682\n" +
                "6225570696\n" +
                "6225570698\n" +
                "6225570704\n" +
                "6225570712\n" +
                "6225570715\n" +
                "6225570723\n" +
                "6225570729\n" +
                "6225570731\n" +
                "6225570736\n" +
                "6225570745\n" +
                "6225570753\n" +
                "6225570761\n" +
                "6225570768\n" +
                "7001673715\n" +
                "7001673728\n" +
                "7001673768\n" +
                "7001673802\n" +
                "7001673808\n" +
                "7001673811\n" +
                "7001673816\n" +
                "7001673843\n" +
                "7001673849\n" +
                "7001673859\n" +
                "7001673899\n" +
                "7001673914\n" +
                "7001673922\n" +
                "7001673930\n" +
                "7001673937\n" +
                "7001673947\n" +
                "7001673985\n" +
                "7001673994\n" +
                "7001674000\n" +
                "7001674008\n" +
                "7001674018\n" +
                "7001674024\n" +
                "7001674025\n" +
                "7001674033\n" +
                "7001674035\n" +
                "7001674040\n" +
                "7001674049\n" +
                "7001674056\n" +
                "7001674065\n" +
                "7001674073\n" +
                "7001674082\n" +
                "7001674088\n" +
                "7001674097\n" +
                "7001674121\n" +
                "7001674129\n" +
                "7001674136\n" +
                "7001674139\n" +
                "7001674145\n" +
                "7001674154\n" +
                "7001674162\n" +
                "7001674170\n" +
                "7001674177\n" +
                "7001674184\n" +
                "7001674201\n" +
                "7001674209\n" +
                "7001674216\n" +
                "7001674232\n" +
                "7001674242\n" +
                "7001674248\n" +
                "7001674266\n" +
                "7001674274\n" +
                "7001674281\n" +
                "7001674289\n" +
                "7001674297\n" +
                "7001674304\n" +
                "7001674315\n" +
                "7001674322\n" +
                "7001674328\n" +
                "7001674337\n" +
                "7001674345\n" +
                "7001674363\n" +
                "7001674393\n" +
                "7001674401\n" +
                "7001674408\n" +
                "7001674424\n" +
                "7001674443\n" +
                "7001674467\n" +
                "7001674472\n" +
                "7001674491\n" +
                "7001674496\n" +
                "7001674497\n" +
                "7001674513\n" +
                "7001674538\n" +
                "7001674546\n" +
                "7001674553\n" +
                "7001674563\n" +
                "7001674578\n" +
                "7001674608\n" +
                "7001674624\n" +
                "7001674627\n" +
                "7001674632\n" +
                "7001674642\n" +
                "7001674649\n" +
                "7001674657\n" +
                "7001674664\n" +
                "7001674674\n" +
                "7001674682\n" +
                "7001674696\n" +
                "7001674706\n" +
                "7001674715\n" +
                "7001674721\n" +
                "7001674728\n" +
                "7001674730\n" +
                "7001674737\n" +
                "7001674746\n" +
                "7001674753\n" +
                "7001674784\n" +
                "7001674794\n" +
                "7001674802\n" +
                "7001674818\n" +
                "7001674824\n" +
                "7001674826\n" +
                "7001674834\n" +
                "7001674840\n" +
                "7001674865\n" +
                "7001674880\n" +
                "7001674891\n" +
                "7001674899\n" +
                "7001674904\n" +
                "7001674915\n" +
                "7001674937\n" +
                "7001674946\n" +
                "7001674955\n" +
                "7001674960\n" +
                "7001674984\n" +
                "7001674995\n" +
                "7001675001\n" +
                "7001675017\n" +
                "7001675025\n" +
                "7001675035\n" +
                "7001675041\n" +
                "7001675050\n" +
                "7001675058\n" +
                "7001675072\n" +
                "7001675089\n" +
                "7001675098\n" +
                "7001675107\n" +
                "7001675121\n" +
                "7001675137\n" +
                "7001675146\n" +
                "7001675154\n" +
                "7001675163\n" +
                "7001675171\n" +
                "7001675179\n" +
                "7001675187\n" +
                "7001675202\n" +
                "7001675209\n" +
                "7001675218\n" +
                "7001675226\n" +
                "7001675232\n" +
                "7001675234\n" +
                "7001675241\n" +
                "7001675250\n" +
                "7001675257\n" +
                "7001675267\n" +
                "7001675272\n" +
                "7001675275\n" +
                "7001675283\n" +
                "7001675289\n" +
                "7001675313\n" +
                "7001675346\n" +
                "7001675352\n" +
                "7001675362\n" +
                "7001675370\n" +
                "7001675377\n" +
                "7001675385\n" +
                "7001675392\n" +
                "7001675411\n" +
                "7001675419\n" +
                "7001675424\n" +
                "7001675450\n" +
                "7001675459\n" +
                "7001675488\n" +
                "7001675496\n" +
                "7001675499\n" +
                "7001675505\n" +
                "7001675515\n" +
                "7001675523\n" +
                "7001675536\n" +
                "7001675553\n" +
                "7001675563\n" +
                "7001675569\n" +
                "7001675577\n" +
                "7001675584\n" +
                "7001675594\n" +
                "7001675602\n" +
                "7001675617\n" +
                "7001675627\n" +
                "7001675643\n" +
                "7001675649\n" +
                "7001675657\n" +
                "7001675666\n" +
                "7001675672\n" +
                "7001675704\n" +
                "7001675723\n" +
                "7001675729\n" +
                "7001675738\n" +
                "7001675746\n" +
                "7001675747\n" +
                "7001675762\n" +
                "7001675769\n" +
                "7001675771\n" +
                "7001675785\n" +
                "7001675794\n" +
                "7001675802\n" +
                "7001675809\n" +
                "7001675817\n" +
                "7001675834\n" +
                "7001675840\n" +
                "7001675864\n" +
                "7001675872\n" +
                "7001675875\n" +
                "7001675882\n" +
                "7001675904\n" +
                "7001675915\n" +
                "7001675923\n" +
                "7001675928\n" +
                "7001675944\n" +
                "7001675955\n" +
                "7001675962\n" +
                "7001675963\n" +
                "7001675969\n" +
                "7001675976\n" +
                "7001675979\n" +
                "7001675985\n" +
                "7001675995\n" +
                "7001676011\n" +
                "7001676017\n" +
                "7001676024\n" +
                "7001676035\n" +
                "7001676043\n" +
                "7001676049\n" +
                "7001676080\n" +
                "7001676098\n" +
                "7001676104\n" +
                "7001676115\n" +
                "7001676122\n" +
                "7001676128\n" +
                "7001676139\n" +
                "7001676144\n" +
                "7001676147\n" +
                "7001676154\n" +
                "7001676163\n" +
                "7001676171\n" +
                "7001676178\n" +
                "7001676186\n" +
                "7001676195\n" +
                "7001676200\n" +
                "7001676210\n" +
                "7001676218\n" +
                "7001676235\n" +
                "7001676241\n" +
                "7001676251\n" +
                "7001676257\n" +
                "7001676267\n" +
                "7001676272\n" +
                "7001676274\n" +
                "7001676282\n" +
                "7001676288\n" +
                "7001676299\n" +
                "7001676306\n" +
                "7001676323\n" +
                "7001676330\n" +
                "7001676336\n" +
                "7001676346\n" +
                "7001676355\n" +
                "7001676386\n" +
                "7001676393\n" +
                "7001676395\n" +
                "7001676418\n" +
                "7001676443\n" +
                "7001676466\n" +
                "7001676482\n" +
                "7001676490\n" +
                "7001676499\n" +
                "7001676506\n" +
                "7001676515\n" +
                "7001676529\n" +
                "7001676546\n" +
                "7001676569\n" +
                "7001676578\n" +
                "7001676584\n" +
                "7001676592\n" +
                "7001676601\n" +
                "7001676608\n" +
                "7001676611\n" +
                "7001676616\n" +
                "7001676632\n" +
                "7001676651\n" +
                "7001676658\n" +
                "7001676664\n" +
                "7001676675\n" +
                "7001676696\n" +
                "7001676706\n" +
                "7001676722\n" +
                "7001676730\n" +
                "7001676760\n" +
                "7001676769\n" +
                "7001676778\n" +
                "7001676784\n" +
                "7001676794\n" +
                "7001676800\n" +
                "7001676825\n" +
                "7001676832\n" +
                "7001676848\n" +
                "7001676859\n" +
                "7001676865\n" +
                "7001676874\n" +
                "7001676880\n" +
                "7001676898\n" +
                "7001676912\n" +
                "7001676939\n" +
                "7001676976\n" +
                "7001676979\n" +
                "7001676994\n" +
                "7001677019\n" +
                "7001677027\n" +
                "7001677033\n" +
                "7001677043\n" +
                "7001677048\n" +
                "7001677049\n" +
                "7001677059\n" +
                "7001677065\n" +
                "7001677075\n" +
                "7001677080\n" +
                "7001677090\n" +
                "7001677107\n" +
                "7001677113\n" +
                "7001677123\n" +
                "7001677131\n" +
                "7001677139\n" +
                "7001677147\n" +
                "7001677154\n" +
                "7001677160\n" +
                "7001677170\n" +
                "7001677186\n" +
                "7001677195\n" +
                "7001677202\n" +
                "7001677209\n" +
                "7001677217\n" +
                "7001677233\n" +
                "7001677243\n" +
                "7001677249\n" +
                "7001677251\n" +
                "7001677258\n" +
                "7001677272\n" +
                "7001677282\n" +
                "7001677288\n" +
                "7001677305\n" +
                "7001677312\n" +
                "7001677322\n" +
                "7001677330\n" +
                "7001677337\n" +
                "7001677339\n" +
                "7001677346\n" +
                "7001677352\n" +
                "7001677353\n" +
                "7001677355\n" +
                "7001677363\n" +
                "7001677369\n" +
                "7001677408\n" +
                "7001677432\n" +
                "7001677443\n" +
                "7001677459\n" +
                "7001677467\n" +
                "7001677475\n" +
                "7001677482\n" +
                "7001677490\n" +
                "7001677507\n" +
                "7001677523\n" +
                "7001677528\n" +
                "7001677531\n" +
                "7001677536\n" +
                "7001677562\n" +
                "7001677568\n" +
                "7001677579\n" +
                "7001677611\n" +
                "7001677617\n" +
                "7001677619\n" +
                "7001677625\n" +
                "7001677632\n" +
                "7001677640\n" +
                "7001677657\n" +
                "7001677664\n" +
                "7001677683\n" +
                "7001677689\n" +
                "7001677698\n" +
                "7001677706\n" +
                "7001677712\n" +
                "7001677720\n" +
                "7001677730\n" +
                "7001677736\n" +
                "7001677746\n" +
                "7001677754\n" +
                "7001677761\n" +
                "7001677769\n" +
                "7001677777\n" +
                "7001677784\n" +
                "7001677800\n" +
                "7001677811\n" +
                "7001677817\n" +
                "7001677840\n" +
                "7001677848\n" +
                "7001677851\n" +
                "7001677873\n" +
                "7001677899\n" +
                "7001677906\n" +
                "7001677912\n" +
                "7001677923\n" +
                "7001677930\n" +
                "7001677947\n" +
                "7001677953\n" +
                "7001677963\n" +
                "7001677985\n" +
                "7001677995\n" +
                "7001678003\n" +
                "7001678011\n" +
                "7001678017\n" +
                "7001678024\n" +
                "7001678034\n" +
                "7001678042\n" +
                "7001678049\n" +
                "7001678059\n" +
                "7001678064\n" +
                "7001678083\n" +
                "7001678089\n" +
                "7001678098\n" +
                "7001678114\n" +
                "7001678121\n" +
                "7001678138\n" +
                "7001678154\n" +
                "7001678160\n" +
                "7001678169\n" +
                "7001678179\n" +
                "7001678184\n" +
                "7001678194\n" +
                "7001678202\n" +
                "7001678211\n" +
                "7001678218\n" +
                "7001678232\n" +
                "7001678241\n" +
                "7001678250\n" +
                "7001678256\n" +
                "7001678259\n" +
                "7001678265\n" +
                "7001678273\n" +
                "7001678282\n" +
                "7001678305\n" +
                "7001678315\n" +
                "7001678321\n" +
                "7001678328\n" +
                "7001678338\n" +
                "7001678344\n" +
                "7001678355\n" +
                "7001678361\n" +
                "7001678369\n" +
                "7001678384\n" +
                "7001678395\n" +
                "7001678402\n" +
                "7001678410\n" +
                "7001678417\n" +
                "7001678426\n" +
                "7001678433\n" +
                "7001678442\n" +
                "7001678448\n" +
                "7001678456\n" +
                "7001678459\n" +
                "7001678466\n" +
                "7001678473\n" +
                "7001678498\n" +
                "7001678507\n" +
                "7001678514\n" +
                "7001678523\n" +
                "7001678529\n" +
                "7001678530\n" +
                "7001678544\n" +
                "7001678563\n" +
                "7001678571\n" +
                "7001678577\n" +
                "7001678585\n" +
                "7001678595\n" +
                "7001678616\n" +
                "7001678624\n" +
                "7001678635\n" +
                "7001678641\n" +
                "7001678648\n" +
                "7001678683\n" +
                "7001678689\n" +
                "7001678697\n" +
                "7001678705\n" +
                "7001678721\n" +
                "7001678731\n" +
                "7001678737\n" +
                "7001678745\n" +
                "7001678762\n" +
                "7001678769\n" +
                "7001678778\n" +
                "7001678803\n" +
                "7001678817\n" +
                "7001678826\n" +
                "7001678834\n" +
                "7001678841\n" +
                "7001678858\n" +
                "7001678865\n" +
                "7001678867\n" +
                "7001678875\n" +
                "7001678883\n" +
                "7001678888\n" +
                "7001678898\n" +
                "7001678915\n" +
                "7001678930\n" +
                "7001678937\n" +
                "7001678945\n" +
                "7001678954\n" +
                "7001678968\n" +
                "7001678985\n" +
                "7001679011\n" +
                "7001679017\n" +
                "7001679026\n" +
                "7001679041\n" +
                "7001679083\n" +
                "7001679089\n" +
                "7001679099\n" +
                "7001679105\n" +
                "7001679115\n" +
                "7001679120\n" +
                "7001679128\n" +
                "7001679137\n" +
                "7001679155\n" +
                "7001679161\n" +
                "7001679170\n" +
                "7001679178\n" +
                "7001679186\n" +
                "7001679194\n" +
                "7001679211\n" +
                "7001679218\n" +
                "7001679256\n" +
                "7001679267\n" +
                "7001679273\n" +
                "7001679282\n" +
                "7001679290\n" +
                "7001679299\n" +
                "7001679331\n" +
                "7001679337\n" +
                "7001679353\n" +
                "7001679360\n" +
                "7001679369\n" +
                "7001679371\n" +
                "7001679378\n" +
                "7001679386\n" +
                "7001679393\n" +
                "7001679401\n" +
                "7001679409\n" +
                "7001679435\n" +
                "7001679441\n" +
                "7001679448\n" +
                "7001679456\n" +
                "7001679465\n" +
                "7001679472\n" +
                "7001679497\n" +
                "7001679512\n" +
                "7001679520\n" +
                "7001679528\n" +
                "7001679545\n" +
                "7001679555\n" +
                "7001679563\n" +
                "7001679577\n" +
                "7001679579\n" +
                "7001679584\n" +
                "7001679592\n" +
                "7001679600\n" +
                "7001679603\n" +
                "7001679608\n" +
                "7001679618\n" +
                "7001679627\n" +
                "7001679633\n" +
                "7001679642\n" +
                "7001679651\n" +
                "7001679657\n" +
                "7001679664\n" +
                "7001679672\n" +
                "7001679689\n" +
                "7001679712\n" +
                "7001679713\n" +
                "7001679722\n" +
                "7001679731\n" +
                "7001679737\n" +
                "7001679744\n" +
                "7001679752\n" +
                "7001679755\n" +
                "7001679763\n" +
                "7001679771\n" +
                "7001679778\n" +
                "7001679787\n" +
                "7001679793\n" +
                "7001679803\n" +
                "7001679811\n" +
                "7001679817\n" +
                "7001679826\n" +
                "7001679833\n" +
                "7001679849\n" +
                "7001679851\n" +
                "7001679872\n" +
                "7001679883\n" +
                "7001679889\n" +
                "7001679920\n" +
                "7001679929\n" +
                "7001679944\n" +
                "7001679978\n" +
                "7001679987\n" +
                "7001680003\n" +
                "7001680011\n" +
                "7001680017\n" +
                "7001680025\n" +
                "7001680033\n" +
                "7001680041\n" +
                "7001680049\n" +
                "7001680059\n" +
                "7001680067\n" +
                "7001680072\n" +
                "7001680080\n" +
                "7001680082\n" +
                "7001680106\n" +
                "7001680112\n" +
                "7001680120\n" +
                "7001680131\n" +
                "7001680137\n" +
                "7001680152\n" +
                "7001680163\n" +
                "7001680168\n" +
                "7001680178\n" +
                "7001680184\n" +
                "7001680193\n" +
                "7001680200\n" +
                "7001680211\n" +
                "7001680216\n" +
                "7001680219\n" +
                "7001680227\n" +
                "7001680249\n" +
                "7001680267\n" +
                "7001680280\n" +
                "7001680288\n" +
                "7001680298\n" +
                "7001680305\n" +
                "7001680312\n" +
                "7001680339\n" +
                "7001680353\n" +
                "7001680368\n" +
                "7001680371\n" +
                "7001680387\n" +
                "7001680393\n" +
                "7001680401\n" +
                "7001680409\n" +
                "7001680419\n" +
                "7001680424\n" +
                "7001680432\n" +
                "7001680441\n" +
                "7001680451\n" +
                "7001680458\n" +
                "7001680465\n" +
                "7001680473\n" +
                "7001680481\n" +
                "7001680488\n" +
                "7001680506\n" +
                "7001680513\n" +
                "7001680523\n" +
                "7001680538\n" +
                "7001680544\n" +
                "7001680546\n" +
                "7001680553\n" +
                "7001680562\n" +
                "7001680568\n" +
                "7001680577\n" +
                "7001680584\n" +
                "7001680602\n" +
                "7001680610\n" +
                "7001680618\n" +
                "7001680624\n" +
                "7001680635\n" +
                "7001680641\n" +
                "7001680651\n" +
                "7001680659\n" +
                "7001680664\n" +
                "7001680667\n" +
                "7001680672\n" +
                "7001680682\n" +
                "7001680691\n" +
                "7001680697\n" +
                "7001680699\n" +
                "7001680704\n" +
                "7001680723\n" +
                "7001680730\n" +
                "7001680747\n" +
                "7001680752\n" +
                "7001680763\n" +
                "7001680776\n" +
                "7001680787\n" +
                "7001680794\n" +
                "7001680801\n" +
                "7001680818\n" +
                "7001680824\n" +
                "7001680835\n" +
                "7001680840\n" +
                "7001680850\n" +
                "7001680856\n" +
                "7001680866\n" +
                "7001680872\n" +
                "7001680874\n" +
                "7001680881\n" +
                "7001680905\n" +
                "7001680915\n" +
                "7001680921\n" +
                "7001680929\n" +
                "7001680939\n" +
                "7001680945\n" +
                "7001680947\n" +
                "7001680952\n" +
                "7001680963\n" +
                "7001680968\n" +
                "7001680971\n" +
                "7001680979\n" +
                "7001680984\n" +
                "7001681010\n" +
                "7001681018\n" +
                "7001681027\n" +
                "7001681049\n" +
                "7001681065\n" +
                "7001681081\n" +
                "7001681088\n" +
                "7001681097\n" +
                "7001681106\n" +
                "7001681112\n" +
                "7001681121\n" +
                "7001681131\n" +
                "7001681139\n" +
                "7001681146\n" +
                "7001681162\n" +
                "7001681168\n" +
                "7001681178\n" +
                "7001681186\n" +
                "7001681224\n" +
                "7001681226\n" +
                "7001681258\n" +
                "7001681259\n" +
                "7001681264\n" +
                "7001681266\n" +
                "7001681273\n" +
                "7001681275\n" +
                "7001681282\n" +
                "7001681291\n" +
                "7001681296\n" +
                "7001681304\n" +
                "7001681313\n" +
                "7001681330\n" +
                "7001681338\n" +
                "7001681355\n" +
                "7001681360\n" +
                "7001681369\n" +
                "7001681387\n" +
                "7001681394\n" +
                "7001681401\n" +
                "7001681419\n" +
                "7001681425\n" +
                "7001681432\n" +
                "7001681440\n" +
                "7001681458\n" +
                "7001681465\n" +
                "7001681467\n" +
                "7001681475\n" +
                "7001681483\n" +
                "7001681491\n" +
                "7001681499\n" +
                "7001681531\n" +
                "7001681538\n" +
                "7001681547\n" +
                "7001681554\n" +
                "7001681560\n" +
                "7001681570\n" +
                "7001681584\n" +
                "7001681594\n" +
                "7001681600\n" +
                "7001681626\n" +
                "7001681632\n" +
                "7001681635\n" +
                "7001681640\n" +
                "7001681648\n" +
                "7001681650\n" +
                "7001681665\n" +
                "7001681675\n" +
                "7001681682\n" +
                "7001681689\n" +
                "7001681699\n" +
                "7001681712\n" +
                "7001681720\n" +
                "7001681722\n" +
                "7001681728\n" +
                "7001681747\n" +
                "7001681752\n" +
                "7001681769\n" +
                "7001681776\n" +
                "7001681778\n" +
                "7001681779\n" +
                "7001681784\n" +
                "7001681802\n" +
                "7001681811\n" +
                "7001681818\n" +
                "7001681843\n" +
                "7001681848\n" +
                "7001681850\n" +
                "7001681851\n" +
                "7001681867\n" +
                "7001681872\n" +
                "7001681875\n" +
                "7001681880\n" +
                "7001681890\n" +
                "7001681907\n" +
                "7001681922\n" +
                "7001681929\n" +
                "7001681938\n" +
                "7001681947\n" +
                "7001681953\n" +
                "7001681962\n" +
                "7001681985\n" +
                "7001682009\n" +
                "7001682035\n" +
                "7001682040\n" +
                "7001682049\n" +
                "7001682057\n" +
                "7001682058\n" +
                "7001682064\n" +
                "7001682073\n" +
                "7001682082\n" +
                "7001682090\n" +
                "7001682097\n" +
                "7001682104\n" +
                "7001682122\n" +
                "7001682129\n" +
                "7001682147\n" +
                "7001682152\n" +
                "7001682169\n" +
                "7001682176\n" +
                "7001682192\n" +
                "7001682194\n" +
                "7001682195\n" +
                "7001682203\n" +
                "7001682209\n" +
                "7001682217\n" +
                "7001682224\n" +
                "7001682233\n" +
                "7001682242\n" +
                "7001682251\n" +
                "7001682258\n" +
                "7001682273\n" +
                "7001682291\n" +
                "7001682307\n" +
                "7001682321\n" +
                "7001682331\n" +
                "7001682344\n" +
                "7001682353\n" +
                "7001682360\n" +
                "7001682368\n" +
                "7001682387\n" +
                "7001682394\n" +
                "7001682401\n" +
                "7001682411\n" +
                "7001682416\n" +
                "7001682425\n" +
                "7001682433\n" +
                "7001682448\n" +
                "7001682481\n" +
                "7001682491\n" +
                "7001682514\n" +
                "7001682520\n" +
                "7001682539\n" +
                "7001682546\n" +
                "7001682555\n" +
                "7001682561\n" +
                "7001682571\n" +
                "7001682593\n" +
                "7001682600\n" +
                "7001682602\n" +
                "7001682608\n" +
                "7001682616\n" +
                "7001682625\n" +
                "7001682634\n" +
                "7001682648\n" +
                "7001682672\n" +
                "7001682682\n" +
                "7001682689\n" +
                "7001682698\n" +
                "7001682704\n" +
                "7001682712\n" +
                "7001682715\n" +
                "7001682721\n" +
                "7001682731\n" +
                "7001682737\n" +
                "7001682745\n" +
                "7001682753\n" +
                "7001682770\n" +
                "7001682776\n" +
                "7001682779\n" +
                "7001682787\n" +
                "7001682793\n" +
                "7001682824\n" +
                "7001682843\n" +
                "7001682849\n" +
                "7001682857\n" +
                "7001682865\n" +
                "7001682873\n" +
                "7001682890\n" +
                "7001682898\n" +
                "7001682904\n" +
                "7001682907\n" +
                "7001682912\n" +
                "7001682915\n" +
                "7001682922\n" +
                "7001682928\n" +
                "7001682931\n" +
                "7001682939\n" +
                "7001682946\n" +
                "7001682952\n" +
                "7001682955\n" +
                "7001682960\n" +
                "7001682979\n" +
                "7001682984\n" +
                "7001682987\n" +
                "7001683000\n" +
                "7001683002\n" +
                "7001683009\n" +
                "7001683016\n" +
                "7001683026\n" +
                "7001683034\n" +
                "7001683035\n" +
                "7001683040\n" +
                "7001683056\n" +
                "7001683091\n" +
                "7001683096\n" +
                "7001683106\n" +
                "7001683112\n" +
                "7001683131\n" +
                "7001683136\n" +
                "7001683144\n" +
                "7001683147\n" +
                "7001683154\n" +
                "7001683162\n" +
                "7001683178\n" +
                "7001683184\n" +
                "7001683192\n" +
                "7001683217\n" +
                "7001683219\n" +
                "7001683227\n" +
                "7001683233\n" +
                "7001683243\n" +
                "7001683251\n" +
                "7001683256\n" +
                "7001683266\n" +
                "7001683281\n" +
                "7001683298\n" +
                "7001683307\n" +
                "7001683314\n" +
                "7001683323\n" +
                "7001683328\n" +
                "7001683344\n" +
                "7001683363\n" +
                "7001683368\n" +
                "7001683376\n" +
                "7001683384\n" +
                "7001683395";

        String[] numsArray = nums.split("\n");
        for (String num : numsArray) {
            System.out.println(Long.parseLong(num) % 256);
        }
    }
}
