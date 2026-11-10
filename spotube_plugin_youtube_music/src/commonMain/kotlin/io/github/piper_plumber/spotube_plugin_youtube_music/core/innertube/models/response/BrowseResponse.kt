package io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.response

import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.Button
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.Continuation
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.GridRenderer
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.Menu
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.MusicDetailHeaderRenderer
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.MusicEditablePlaylistDetailHeaderRenderer
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.MusicShelfRenderer
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.ResponseContext
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.Runs
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.SectionListRenderer
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.SubscriptionButton
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.Tabs
import io.github.piper_plumber.spotube_plugin_youtube_music.core.innertube.models.ThumbnailRenderer
import kotlinx.serialization.Serializable

@Serializable
data class BrowseResponse(
    val contents: Contents? = null,
    val continuationContents: ContinuationContents? = null,
    val onResponseReceivedActions: List<ResponseAction>? = null,
    val header: Header? = null,
    val microformat: Microformat? = null,
    val responseContext: ResponseContext? = null,
    val background: ThumbnailRenderer? = null
) {
    @Serializable
    data class Contents(
        val singleColumnBrowseResultsRenderer: Tabs?,
        val sectionListRenderer: SectionListRenderer?,
        val twoColumnBrowseResultsRenderer: TwoColumnBrowseResultsRenderer?,
    )

    @Serializable
    data class TwoColumnBrowseResultsRenderer(
        val tabs: List<Tabs.Tab?>?,
        val secondaryContents: SecondaryContents?,
    )
    @Serializable
    data class SecondaryContents(
        val sectionListRenderer: SectionListRenderer?,
    )

    @Serializable
    data class ContinuationContents(
        val sectionListContinuation: SectionListContinuation?,
        val musicPlaylistShelfContinuation: MusicPlaylistShelfContinuation?,
        val gridContinuation: GridContinuation?,
        val musicShelfContinuation: MusicShelfRenderer?
    ) {
        @Serializable
        data class SectionListContinuation(
            val contents: List<SectionListRenderer.Content> = emptyList(),
            val continuations: List<Continuation>?,
        )

        @Serializable
        data class MusicPlaylistShelfContinuation(
            val contents: List<MusicShelfRenderer.Content> = emptyList(),
            val continuations: List<Continuation>?,
        )

        @Serializable
        data class GridContinuation(
            val items: List<GridRenderer.Item> = emptyList(),
            val continuations: List<Continuation>?,
        )
    }

    @Serializable
    data class ResponseAction(
        val appendContinuationItemsAction: ContinuationItems?,
    ) {
        @Serializable
        data class ContinuationItems(
            val continuationItems: List<MusicShelfRenderer.Content>?,
        )
    }

    @Serializable
    data class Header(
        val musicImmersiveHeaderRenderer: MusicImmersiveHeaderRenderer?,
        val musicDetailHeaderRenderer: MusicDetailHeaderRenderer?,
        val musicEditablePlaylistDetailHeaderRenderer: MusicEditablePlaylistDetailHeaderRenderer?,
        val musicVisualHeaderRenderer: MusicVisualHeaderRenderer?,
        val musicHeaderRenderer: MusicHeaderRenderer?,
    ) {
        @Serializable
        data class MusicImmersiveHeaderRenderer(
            val title: Runs? = null,
            val description: Runs? = null,
            val thumbnail: ThumbnailRenderer? = null,
            val playButton: Button? = null,
            val startRadioButton: Button? = null,
            val subscriptionButton: SubscriptionButton? = null,
            val menu: Menu? = null,
            val subscriptionButton2: SubscriptionButton2? = null,
            val monthlyListenerCount: Runs? = null,
        ) {
            @Serializable
            data class SubscriptionButton2(
                val subscribeButtonRenderer: SubscribeButtonRenderer?,
            ) {
                @Serializable
                data class SubscribeButtonRenderer(
                    val subscriberCountWithSubscribeText: Runs?,
                )
            }
        }

        @Serializable
        data class MusicVisualHeaderRenderer(
            val title: Runs? = null,
            val foregroundThumbnail: ThumbnailRenderer? = null,
            val thumbnail: ThumbnailRenderer? = null,
            val subscriptionButton: SubscriptionButton? = null,
        )

        @Serializable
        data class Buttons(
            val menuRenderer: Menu.MenuRenderer?,
        )

        @Serializable
        data class MusicHeaderRenderer(
            val buttons: List<Buttons>?,
            val title: Runs?,
            val thumbnail: MusicThumbnailRenderer?,
            val subtitle: Runs?,
            val secondSubtitle: Runs?,
            val straplineTextOne: Runs?,
            val straplineThumbnail: MusicThumbnailRenderer?,
        )
        @Serializable
        data class MusicThumbnail(
            val url: String?,
        )
        @Serializable
        data class MusicThumbnailRenderer(
            val musicThumbnailRenderer: MusicThumbnailRenderer,
            val thumbnails: List<MusicThumbnail>?,
        )
    }

    @Serializable
    data class Microformat(
        val microformatDataRenderer: MicroformatDataRenderer?,
    ) {
        @Serializable
        data class MicroformatDataRenderer(
            val urlCanonical: String?,
        )
    }
}
