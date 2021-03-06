/*
 * Copyright 2018-2020 ProfunKtor
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

package dev.profunktor.redis4cats.algebra

import java.time.Instant

import dev.profunktor.redis4cats.data.KeyScanCursor
import dev.profunktor.redis4cats.effects.ScanArgs

import scala.concurrent.duration.FiniteDuration

trait KeyCommands[F[_], K] {
  def del(key: K*): F[Long]
  def exists(key: K*): F[Boolean]
  def expire(key: K, expiresIn: FiniteDuration): F[Boolean]
  def expireAt(key: K, at: Instant): F[Boolean]
  def objectIdletime(key: K): F[Option[FiniteDuration]]
  def ttl(key: K): F[Option[FiniteDuration]]
  def pttl(key: K): F[Option[FiniteDuration]]
  def scan: F[KeyScanCursor[K]]
  def scan(cursor: Long): F[KeyScanCursor[K]]
  def scan(scanArgs: ScanArgs): F[KeyScanCursor[K]]
  def scan(cursor: Long, scanArgs: ScanArgs): F[KeyScanCursor[K]]
}
