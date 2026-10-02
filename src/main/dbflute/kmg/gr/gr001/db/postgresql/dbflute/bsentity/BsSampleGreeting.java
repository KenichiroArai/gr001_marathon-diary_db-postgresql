package kmg.gr.gr001.db.postgresql.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import kmg.gr.gr001.db.postgresql.dbflute.allcommon.DBMetaInstanceHandler;
import kmg.gr.gr001.db.postgresql.dbflute.exentity.*;

/**
 * The entity of sample_greeting as TABLE. <br>
 * サンプル挨拶
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsSampleGreeting extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** sample_greeting_id: {PK, ID, NotNull, int8(19)} */
    protected Long _sampleGreetingId;

    /** message: {NotNull, varchar(200)} */
    protected String _message;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "sample_greeting";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_sampleGreetingId == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsSampleGreeting) {
            BsSampleGreeting other = (BsSampleGreeting)obj;
            if (!xSV(_sampleGreetingId, other._sampleGreetingId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _sampleGreetingId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_sampleGreetingId));
        sb.append(dm).append(xfND(_message));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public SampleGreeting clone() {
        return (SampleGreeting)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] sample_greeting_id: {PK, ID, NotNull, int8(19)} <br>
     * サンプル挨拶ID
     * @return The value of the column 'sample_greeting_id'. (basically NotNull if selected: for the constraint)
     */
    public Long getSampleGreetingId() {
        checkSpecifiedProperty("sampleGreetingId");
        return _sampleGreetingId;
    }

    /**
     * [set] sample_greeting_id: {PK, ID, NotNull, int8(19)} <br>
     * サンプル挨拶ID
     * @param sampleGreetingId The value of the column 'sample_greeting_id'. (basically NotNull if update: for the constraint)
     */
    public void setSampleGreetingId(Long sampleGreetingId) {
        registerModifiedProperty("sampleGreetingId");
        _sampleGreetingId = sampleGreetingId;
    }

    /**
     * [get] message: {NotNull, varchar(200)} <br>
     * メッセージ
     * @return The value of the column 'message'. (basically NotNull if selected: for the constraint)
     */
    public String getMessage() {
        checkSpecifiedProperty("message");
        return _message;
    }

    /**
     * [set] message: {NotNull, varchar(200)} <br>
     * メッセージ
     * @param message The value of the column 'message'. (basically NotNull if update: for the constraint)
     */
    public void setMessage(String message) {
        registerModifiedProperty("message");
        _message = message;
    }
}
