package com.leisucn.xa.newsc2c.trans.baidu;


import com.leisucn.xa.newsc2c.trans.baidu.translate.TransApi;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "There has probably been more capital looking to invest in private technology companies in the past five years than any five-year period before.\n" +
                "An obvious consequence of this increased supply is that company valuations (i.e. prices) have gone up, and so has the amount of capital raised by most companies.\n" +
                "A non-obvious consequence is that although people raise more money at higher valuations, they still end up selling much more of the company.\n" +
                "For a long time, when the early-stage fundraising market was much tougher, YC’s standard advice to companies was to raise as much as they reasonably could. Someday that advice will likely be correct again, but right now, the market has shifted.\n" +
                "It sounds like a better deal to raise $5 million on a $10 million pre-money valuation (selling 33% of the company to investors) than $615,000 at a $2.4 million pre-money valuation (selling ~20% of the company to investors, which is what Airbnb did). But this is only true if you put the money to exceptionally good use. Otherwise, you may end up with a lower dollar value of the equity you keep.\n" +
                "Today, each percentage point of Airbnb is worth about $300 million. I expect them to be worth more in future. If you hope your company will one day be extremely successful, then treat your equity as such. (The one place I recommend not being stingy with equity is when it comes to giving it to employees—most founders’ instincts seem to be to give too much equity to investors and not enough to employees.)\n" +
                "Terms like ‘seed round’ and ‘Series A’ are less clear than they used to be, but in general, I recommend companies think about selling 10-15% in a seed round and 15-25% in their A round (and about 7% if they go through an accelerator). When these combine into one large initial round, I suggest trying to sell no more than 30% of the company in total.\n" +
                "I also suggest founders take the time to model this all out (or use Angelcalc, built by my partner Geoff Ralston). Founders are often surprised about how choosing to raise less helps protect their ownership more than negotiating valuation does.\n" +
                "Of course, it’s easy to take this advice too far. It’s more important not to run out of money than almost anything else.\n" +
                "I have recently seen several examples of companies doing pretty well and going out to raise B rounds with investors already owning 50-60% of the company. In all cases, they are having a tough time. As one very successful investor says, “one of the immutable laws of venture is that there are only 100 points on the cap table”. At some point, it gets hard to make it all work. Selling a few percentage points too many won’t kill you, but selling 30 points too many may.\n" +
                "Remember that raising money is not success. Raising huge amounts of money early on is very rarely how companies win (though it is sometimes how companies lose). Be one of those companies that does a lot with a little, instead of a little with a lot. Resist the urge to seek validation by having a long list of impressive sounding investors.\n" +
                "Constraints are wonderfully focusing. Excess capital usually ends up making its way into the hands of landlords of some sort anyway. And if you end up being the next Airbnb, you’ll be really happy you held on to that equity.";
        System.out.println(api.getTransResult(query, "auto", "zh"));
    }

}
