import React from "react"
import axios from "axios"

class Test extends React.Component {
	// getData() {
	// 	axios
	// 		.get("https://www.googleapis.com/books/v1/volumes?q=react")
	// 		.then((r) => {
	// 			r.data.items.map((m) => {
	// 				console.log(m.volumeInfo.title)
	// 			})
	// 		})
	// }

	render() {
		this.hoge()
		return <div>hello</div>
	}
}

export default Test
