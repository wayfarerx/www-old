/*
 * Drinks.scala
 *
 * Copyright 2018 wayfarerx <x@wayfarerx.net> (@thewayfarerx)
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
package drinks

import cats.effect.IO
import net.wayfarerx.oversite._
import scalatags.Text
import scalatags.Text.all._

/**
 * The drinks landing page.
 *
 * @param metadata The metadata of this page.
 */
case class Drinks(metadata: Metadata)

/**
 * Definition of the drinks section of the wayfarerx.net website.
 */
object Drinks {

  /** The scopes contained in this section. */
  lazy val scope: Scope[_ <: AnyRef] = Scope[Drinks]()

  /** The drinks landing page decoder. */
  implicit val decoder: Decoder[Drinks] = new Decoder[Drinks] {

    override def decode(doc: Document)(implicit ctx: Context): IO[Drinks] =
      IO.pure(Drinks(doc.metadata))

  }

  /** The drinks landing page publisher. */
  implicit val publisher: Publisher[Drinks] = new Publisher[Drinks] with ui.Template.Support[Drinks] {

    override protected def display(entity: Drinks)(implicit ctx: Context): IO[Text.all.Frag] =
      ???

  }

}
