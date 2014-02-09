/**
 * Translation of RxLinq Defer example from msdn: http://msdn.microsoft.com/en-us/library/hh229160.aspx
 * RxJava wiki: https://github.com/Netflix/RxJava/wiki/Creating-Observables#wiki-defer
 * Created by ashokgelal on 2/9/14.
 */

package rxdemo

import rx.Observable

public class RxDefer(){
    public fun run() {
        var inventory = ProductInventory()
        var observable = Observable.defer { inventory.getUpdatedInventory() }

        val header1 = "Product Name\t\t\tProduct ID\t\t\t\t\t\t\t\t\tCurrent Inventory"
        val header2 = "============\t\t\t==========\t\t\t\t\t\t\t\t\t================="

        println("Current Inventory...\n\n")
        println(header1)
        println(header2)
        observable!!.subscribe { println(it) }

        println("\n\nThe updated current Inventory...\n\n")
        println(header1)
        println(header2)
        observable!!.subscribe { println(it) }
    }
}
