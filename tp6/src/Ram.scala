case class Ram(size: Int, pageSize: Int) {
  private var ramPages: List[Page] = Nil
  private val maxPageQty = size / pageSize

  def store(page: Page) = {
    if (ramPages.length >= maxPageQty) throw new IllegalStateException("Full memory")
    else if (ramPages.length + 1 > maxPageQty) throw new IllegalStateException("Not enough memory")
    else ramPages = page :: ramPages
  }

  def store(pages: Array[Page]) = {
    if (ramPages.length >= maxPageQty) throw new IllegalStateException("Full memory")
    else if (ramPages.length + pages.length > maxPageQty) throw new IllegalStateException("Not enough memory")
    else pages.foreach(p => ramPages = p :: ramPages)
  }
}
