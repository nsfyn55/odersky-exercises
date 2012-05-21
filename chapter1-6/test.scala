val myList = "foo" :: "all your base" :: Nil
myList.partition(_.length > 3)
