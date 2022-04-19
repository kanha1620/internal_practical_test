package com.exam.internal_practical_test

data class fruit(var Fr_name:String,var Fr_des:String,var Fr_price:Int)
{
    var id:Int=0
    constructor(id:Int,Fr_name: String,Fr_des: String,Fr_price: Int)
    :this(Fr_name,Fr_des, Fr_price)
    {
        this.id=id
    }
}