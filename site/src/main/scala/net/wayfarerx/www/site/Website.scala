/*
 * Website.scala
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
package site

import net.wayfarerx.oversite._

/**
 * Definition of the wayfarerx.net website.
 */
final class Website extends Site[Home] {

  /* The name of the site. */
  override val name: Name = name"wayfarerx.net"

  /* The author of the site. */
  override val owner: Author = Author(name"wayfarerx")

  /* The base URL of the site. */
  override val baseUrl: String = "https://wayfarerx.net"

  /* The entry point for the scopes that describe this site. */
  override lazy val scopes: Scope[Home] = Scope.Aliased[Home](
    Path("net/wayfarerx/www/site"),
    Styles.generator :: HomeStyles.generator :: Nil
  )

}
