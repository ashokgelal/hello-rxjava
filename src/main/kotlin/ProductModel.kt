/**
 * Created by ashokgelal on 2/9/14.
 */

package rxdemo

import java.util.UUID
import java.util.Random
import rx.Observable

public class Product(val productName: String, var currentInventory: Int){
    private val productID = UUID.randomUUID()
    public fun removeInventory(delta: Int) {
        currentInventory -= delta
        when {
            currentInventory < 0 -> currentInventory = 0
        }
    }

    public fun toString(): String = "$productName\t\t\t\t$productID\t\t$currentInventory"
}

public class ProductInventory(){
    private var random = Random()
    var products = Array<Product>(5, { i -> Product("Product ${i + 1}", random.nextInt(1000)) })

    public fun getUpdatedInventory(): Observable<Product>? {
        for (i in 0..5 - 1) products[i].removeInventory(random.nextInt(51))
        return Observable.from(products)
    }
}
