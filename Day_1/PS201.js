function reverse(num)
{
    let temp=num;
    let rev=0;
    while(temp!=0)
    {
        let d=temp%10;
        temp=Math.floor(temp/10);
        rev=rev*10+d;
    }
    return rev;
}
 let num=121;
 rev=reverse(num);
 if(rev==num)
 {
    console.log(num+" is pallindrome");
 }
 else
 {
    console.log(num+" is not pallindrome");
 }