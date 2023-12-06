abstract trait Food {}

abstract trait Animal(name: String) {
  type FoodType <: Food
  def eat(f: FoodType) = {
    println(s"eating: $f")
  }
}

abstract trait NonMeat extends Food
abstract trait Meat extends Food

case class Grass() extends NonMeat 
case class Hay() extends NonMeat 

case class Cow(name: String) extends Animal(name), Meat {
  type FoodType = NonMeat
  override def eat(f: FoodType) = {
    super.eat(f)
  }
}

case class Wolf(name: String) extends Animal(name) {
  type FoodType = Meat
  override def eat(f: FoodType) = {
    super.eat(f)
  }
}

@main def hello: Unit = {
  val g = new Grass()
  val h = new Hay()
  val c1 = new Cow("cow1")
  val c2 = new Cow("cow2")

  val wolf = new Wolf("bad one")
  c1.eat(g)
  c2.eat(h)
  // c1.eat(c2)
  wolf.eat(c1)

  println("Hello world!")
}
