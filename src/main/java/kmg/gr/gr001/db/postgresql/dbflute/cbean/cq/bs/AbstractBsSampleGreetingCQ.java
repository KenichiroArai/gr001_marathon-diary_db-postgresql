package kmg.gr.gr001.db.postgresql.dbflute.cbean.cq.bs;

import java.util.*;

import org.dbflute.cbean.*;
import org.dbflute.cbean.chelper.*;
import org.dbflute.cbean.ckey.*;
import org.dbflute.cbean.coption.*;
import org.dbflute.cbean.cvalue.ConditionValue;
import org.dbflute.cbean.ordering.*;
import org.dbflute.cbean.scoping.*;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.dbflute.dbmeta.DBMetaProvider;
import kmg.gr.gr001.db.postgresql.dbflute.allcommon.*;
import kmg.gr.gr001.db.postgresql.dbflute.cbean.*;
import kmg.gr.gr001.db.postgresql.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of sample_greeting.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsSampleGreetingCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsSampleGreetingCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    public String asTableDbName() {
        return "sample_greeting";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingId The value of sampleGreetingId as equal. (basically NotNull: error as default, or no condition as option)
     */
    public void setSampleGreetingId_Equal(Long sampleGreetingId) {
        doSetSampleGreetingId_Equal(sampleGreetingId);
    }

    protected void doSetSampleGreetingId_Equal(Long sampleGreetingId) {
        regSampleGreetingId(CK_EQ, sampleGreetingId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingId The value of sampleGreetingId as notEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setSampleGreetingId_NotEqual(Long sampleGreetingId) {
        doSetSampleGreetingId_NotEqual(sampleGreetingId);
    }

    protected void doSetSampleGreetingId_NotEqual(Long sampleGreetingId) {
        regSampleGreetingId(CK_NES, sampleGreetingId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingId The value of sampleGreetingId as greaterThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setSampleGreetingId_GreaterThan(Long sampleGreetingId) {
        regSampleGreetingId(CK_GT, sampleGreetingId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingId The value of sampleGreetingId as lessThan. (basically NotNull: error as default, or no condition as option)
     */
    public void setSampleGreetingId_LessThan(Long sampleGreetingId) {
        regSampleGreetingId(CK_LT, sampleGreetingId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingId The value of sampleGreetingId as greaterEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setSampleGreetingId_GreaterEqual(Long sampleGreetingId) {
        regSampleGreetingId(CK_GE, sampleGreetingId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingId The value of sampleGreetingId as lessEqual. (basically NotNull: error as default, or no condition as option)
     */
    public void setSampleGreetingId_LessEqual(Long sampleGreetingId) {
        regSampleGreetingId(CK_LE, sampleGreetingId);
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param minNumber The min number of sampleGreetingId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of sampleGreetingId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param opLambda The callback for option of range-of. (NotNull)
     */
    public void setSampleGreetingId_RangeOf(Long minNumber, Long maxNumber, ConditionOptionCall<RangeOfOption> opLambda) {
        setSampleGreetingId_RangeOf(minNumber, maxNumber, xcROOP(opLambda));
    }

    /**
     * RangeOf with various options. (versatile) <br>
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br>
     * And NullIgnored, OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param minNumber The min number of sampleGreetingId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param maxNumber The max number of sampleGreetingId. (basically NotNull: if op.allowOneSide(), null allowed)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    protected void setSampleGreetingId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, xgetCValueSampleGreetingId(), "sample_greeting_id", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingIdList The collection of sampleGreetingId as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSampleGreetingId_InScope(Collection<Long> sampleGreetingIdList) {
        doSetSampleGreetingId_InScope(sampleGreetingIdList);
    }

    protected void doSetSampleGreetingId_InScope(Collection<Long> sampleGreetingIdList) {
        regINS(CK_INS, cTL(sampleGreetingIdList), xgetCValueSampleGreetingId(), "sample_greeting_id");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     * @param sampleGreetingIdList The collection of sampleGreetingId as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setSampleGreetingId_NotInScope(Collection<Long> sampleGreetingIdList) {
        doSetSampleGreetingId_NotInScope(sampleGreetingIdList);
    }

    protected void doSetSampleGreetingId_NotInScope(Collection<Long> sampleGreetingIdList) {
        regINS(CK_NINS, cTL(sampleGreetingIdList), xgetCValueSampleGreetingId(), "sample_greeting_id");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     */
    public void setSampleGreetingId_IsNull() { regSampleGreetingId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br>
     * sample_greeting_id: {PK, ID, NotNull, int8(19)}
     */
    public void setSampleGreetingId_IsNotNull() { regSampleGreetingId(CK_ISNN, DOBJ); }

    protected void regSampleGreetingId(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueSampleGreetingId(), "sample_greeting_id"); }
    protected abstract ConditionValue xgetCValueSampleGreetingId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as equal. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_Equal(String message) {
        doSetMessage_Equal(fRES(message));
    }

    protected void doSetMessage_Equal(String message) {
        regMessage(CK_EQ, message);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as notEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_NotEqual(String message) {
        doSetMessage_NotEqual(fRES(message));
    }

    protected void doSetMessage_NotEqual(String message) {
        regMessage(CK_NES, message);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as greaterThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_GreaterThan(String message) {
        regMessage(CK_GT, fRES(message));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as lessThan. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_LessThan(String message) {
        regMessage(CK_LT, fRES(message));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as greaterEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_GreaterEqual(String message) {
        regMessage(CK_GE, fRES(message));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as lessEqual. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_LessEqual(String message) {
        regMessage(CK_LE, fRES(message));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param messageList The collection of message as inScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_InScope(Collection<String> messageList) {
        doSetMessage_InScope(messageList);
    }

    protected void doSetMessage_InScope(Collection<String> messageList) {
        regINS(CK_INS, cTL(messageList), xgetCValueMessage(), "message");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param messageList The collection of message as notInScope. (basically NotNull, NotEmpty: error as default, or no condition as option)
     */
    public void setMessage_NotInScope(Collection<String> messageList) {
        doSetMessage_NotInScope(messageList);
    }

    protected void doSetMessage_NotInScope(Collection<String> messageList) {
        regINS(CK_NINS, cTL(messageList), xgetCValueMessage(), "message");
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * message: {NotNull, varchar(200)} <br>
     * <pre>e.g. setMessage_LikeSearch("xxx", op <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> op.<span style="color: #CC4747">likeContain()</span>);</pre>
     * @param message The value of message as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setMessage_LikeSearch(String message, ConditionOptionCall<LikeSearchOption> opLambda) {
        setMessage_LikeSearch(message, xcLSOP(opLambda));
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br>
     * message: {NotNull, varchar(200)} <br>
     * <pre>e.g. setMessage_LikeSearch("xxx", new <span style="color: #CC4747">LikeSearchOption</span>().likeContain());</pre>
     * @param message The value of message as likeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    protected void setMessage_LikeSearch(String message, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(message), xgetCValueMessage(), "message", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param opLambda The callback for option of like-search. (NotNull)
     */
    public void setMessage_NotLikeSearch(String message, ConditionOptionCall<LikeSearchOption> opLambda) {
        setMessage_NotLikeSearch(message, xcLSOP(opLambda));
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br>
     * And NullOrEmptyIgnored, SeveralRegistered. <br>
     * message: {NotNull, varchar(200)}
     * @param message The value of message as notLikeSearch. (basically NotNull, NotEmpty: error as default, or no condition as option)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    protected void setMessage_NotLikeSearch(String message, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(message), xgetCValueMessage(), "message", likeSearchOption);
    }

    protected void regMessage(ConditionKey ky, Object vl) { regQ(ky, vl, xgetCValueMessage(), "message"); }
    protected abstract ConditionValue xgetCValueMessage();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO = (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SampleGreetingCB> scalar_Equal() {
        return xcreateSLCFunction(CK_EQ, SampleGreetingCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br>
     * {where FOO &lt;&gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SampleGreetingCB> scalar_NotEqual() {
        return xcreateSLCFunction(CK_NES, SampleGreetingCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br>
     * {where FOO &gt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SampleGreetingCB> scalar_GreaterThan() {
        return xcreateSLCFunction(CK_GT, SampleGreetingCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br>
     * {where FOO &lt; (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SampleGreetingCB> scalar_LessThan() {
        return xcreateSLCFunction(CK_LT, SampleGreetingCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br>
     * {where FOO &gt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().scalar_Equal().<span style="color: #CC4747">avg</span>(<span style="color: #553000">purchaseCB</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">purchaseCB</span>.specify().<span style="color: #CC4747">columnPurchasePrice</span>(); <span style="color: #3F7E5E">// *Point!</span>
     *     <span style="color: #553000">purchaseCB</span>.query().setPaymentCompleteFlg_Equal_True();
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SampleGreetingCB> scalar_GreaterEqual() {
        return xcreateSLCFunction(CK_GE, SampleGreetingCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br>
     * {where FOO &lt;= (select max(BAR) from ...)}
     * <pre>
     * cb.query().<span style="color: #CC4747">scalar_LessEqual()</span>.max(new SubQuery&lt;SampleGreetingCB&gt;() {
     *     public void query(SampleGreetingCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSLCFunction<SampleGreetingCB> scalar_LessEqual() {
        return xcreateSLCFunction(CK_LE, SampleGreetingCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSLCCustomized<CB> cs, ScalarConditionOption op) {
        assertObjectNotNull("subQuery", sq);
        SampleGreetingCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        cs.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, cs, op);
    }
    public abstract String keepScalarCondition(SampleGreetingCQ sq);

    protected SampleGreetingCB xcreateScalarConditionCB() {
        SampleGreetingCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected SampleGreetingCB xcreateScalarConditionPartitionByCB() {
        SampleGreetingCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<SampleGreetingCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SampleGreetingCB cb = new SampleGreetingCB(); cb.xsetupForDerivedReferrer(this);
        lockCall(() -> sq.query(cb)); String pp = keepSpecifyMyselfDerived(cb.query()); String pk = "sample_greeting_id";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(SampleGreetingCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<SampleGreetingCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(SampleGreetingCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        SampleGreetingCB cb = new SampleGreetingCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "sample_greeting_id";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(SampleGreetingCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subCBLambda The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<SampleGreetingCB> subCBLambda) {
        assertObjectNotNull("subCBLambda", subCBLambda);
        SampleGreetingCB cb = new SampleGreetingCB(); cb.xsetupForMyselfExists(this);
        lockCall(() -> subCBLambda.query(cb)); String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(SampleGreetingCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #CC4747">withManualOrder</span>(<span style="color: #553000">op</span> <span style="color: #90226C; font-weight: bold"><span style="font-size: 120%">-</span>&gt;</span> {
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     *     <span style="color: #553000">op</span>.<span style="color: #CC4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * });
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param opLambda The callback for option of manual-order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderOptionCall opLambda) { // is user public!
        xdoWithManualOrder(cMOO(opLambda));
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected SampleGreetingCB newMyCB() {
        return new SampleGreetingCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return SampleGreetingCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSLCS() { return HpSLCSetupper.class.getName(); }
    protected String xabSCP() { return SubQuery.class.getName(); }
}
