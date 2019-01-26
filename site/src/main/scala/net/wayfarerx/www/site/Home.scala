/*
 * Home.scala
 *
 * Copyright 2018-2019 wayfarerx <x@wayfarerx.net> (@thewayfarerx)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.wayfarerx.www
package site

import cats.effect.IO

import scalatags.Text.all._

import net.wayfarerx.oversite._

case class Home(image: Markup.Image)

object Home {

  implicit val decoder: Decoder[Home] = Decoder[Home] {
    case Document(_, List(Markup.Paragraph(List(image: Markup.Image))), Nil) => Home(image)
  }

  implicit val publisher: Publisher[Home] = new ui.Template.Support[Home] {

    override def stylesheets(entity: Home)(implicit ctx: Context): IO[Vector[ui.Template.Reference]] = for {
      href <- ui.Href(Pointer.Stylesheet(HomeStyles.name))
      parent <- super.stylesheets(entity)
    } yield parent :+ ui.Template.Reference(href)

    override def display(entity: Home)(implicit ctx: Context): IO[Frag] =
      entity.image.render(cls := "home-logo")

  }


}
