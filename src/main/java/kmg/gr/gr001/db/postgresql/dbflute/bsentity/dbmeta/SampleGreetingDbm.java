package kmg.gr.gr001.db.postgresql.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import kmg.gr.gr001.db.postgresql.dbflute.allcommon.*;
import kmg.gr.gr001.db.postgresql.dbflute.exentity.*;

/**
 * The DB meta of sample_greeting. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class SampleGreetingDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final SampleGreetingDbm _instance = new SampleGreetingDbm();
    private SampleGreetingDbm() {}
    public static SampleGreetingDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((SampleGreeting)et).getSampleGreetingId(), (et, vl) -> ((SampleGreeting)et).setSampleGreetingId(ctl(vl)), "sampleGreetingId");
        setupEpg(_epgMap, et -> ((SampleGreeting)et).getMessage(), (et, vl) -> ((SampleGreeting)et).setMessage((String)vl), "message");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "sample_greeting";
    protected final String _tableDispName = "sample_greeting";
    protected final String _tablePropertyName = "sampleGreeting";
    protected final TableSqlName _tableSqlName = new TableSqlName("sample_greeting", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnSampleGreetingId = cci("sample_greeting_id", "sample_greeting_id", null, null, Long.class, "sampleGreetingId", null, true, true, true, "int8", 19, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnMessage = cci("message", "message", null, null, String.class, "message", null, false, false, true, "varchar", 200, 0, null, null, false, null, null, null, null, null, false);

    /**
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnSampleGreetingId() { return _columnSampleGreetingId; }
    /**
     * message: {NotNull, varchar(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessage() { return _columnMessage; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnSampleGreetingId());
        ls.add(columnMessage());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnSampleGreetingId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "kmg.gr.gr001.db.postgresql.dbflute.exentity.SampleGreeting"; }
    public String getConditionBeanTypeName() { return "kmg.gr.gr001.db.postgresql.dbflute.cbean.SampleGreetingCB"; }
    public String getBehaviorTypeName() { return "kmg.gr.gr001.db.postgresql.dbflute.exbhv.SampleGreetingBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<SampleGreeting> getEntityType() { return SampleGreeting.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public SampleGreeting newEntity() { return new SampleGreeting(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((SampleGreeting)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((SampleGreeting)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
