package kmg.gr.gr001.db.postgresql.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import kmg.gr.gr001.db.postgresql.dbflute.exbhv.*;
import kmg.gr.gr001.db.postgresql.dbflute.exentity.*;

/**
 * The referrer loader of sample_greeting as TABLE.
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfSampleGreeting {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<SampleGreeting> _selectedList;
    protected BehaviorSelector _selector;
    protected SampleGreetingBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfSampleGreeting ready(List<SampleGreeting> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected SampleGreetingBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(SampleGreetingBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<SampleGreeting> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
