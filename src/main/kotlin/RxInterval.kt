/**
 *
 * Translation of RxLinq Defer example from msdn: http://msdn.microsoft.com/en-us/library/hh228911.aspx
 * RxJava wiki: https://github.com/Netflix/RxJava/wiki/Creating-Observables#wiki-interval
 * Created by ashokgelal on 2/9/14.
 *
 */

import rx.schedulers.NewThreadScheduler
import java.text.SimpleDateFormat
import rx.Observable
import java.util.concurrent.TimeUnit
import java.util.Date

public class RxInterval(){

    public fun run() {
        var formatter = SimpleDateFormat("h:mm:ss a")
        val periodInSec = 2L

        var obs = Observable.interval(periodInSec, TimeUnit.SECONDS, NewThreadScheduler.getInstance())
        val subscription = obs?.subscribe { println("Integer: ${it}\tCurrent Time: ${formatter.format(Date())}") }

        println("Press ENTER to exit...\n")
        readLine()
        subscription?.unsubscribe()
    }
}