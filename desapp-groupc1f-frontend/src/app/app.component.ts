import { Component } from '@angular/core';
import { icon, latLng, Map, marker, point, polyline, tileLayer } from 'leaflet';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'desapp-groupc1f-frontend';

  // Define our base layers so we can reference them multiple times
  streetMaps = tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    detectRetina: true,
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
  });
  wMaps = tileLayer('http://maps.wikimedia.org/osm-intl/{z}/{x}/{y}.png', {
    detectRetina: true,
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
  });

  // Marker for the top of Mt. Ranier
  //UNQ
  summit = marker([ -34.706280, -58.278616 ], {
    icon: icon({
      iconSize: [ 25, 41 ],
      iconAnchor: [ 13, 41 ],
      iconUrl: 'leaflet/marker-icon.png',
      shadowUrl: 'leaflet/marker-shadow.png'
    })
  });

  // Marker for the parking lot at the base of Mt. Ranier trails
  //Estación Bernal
  paradise = marker([ -34.709425, -58.280429 ], {
    icon: icon({
      iconSize: [ 25, 41 ],
      iconAnchor: [ 13, 41 ],
      iconUrl: 'leaflet/marker-icon.png',
      shadowUrl: 'leaflet/marker-shadow.png'
    })
  });

  // Path from paradise to summit - most points omitted from this example for brevity
  //Puntos intermedios para trazar un camino a dibujar
  route = polyline([[ -34.706280, -58.278616 ],
    [ -34.707082, -58.278899 ],
    [ -34.708165, -58.279170 ],
    [ -34.708966, -58.279522 ],
    [ -34.709425, -58.280429 ]]);

  //De esta manera, traza una linea recta entre dos puntos
  //route = polyline([[ -34.706280, -58.278616 ], [ -34.709425, -58.280429 ]]);


  // Layers control object with our two base layers and the three overlay layers
  layersControl = {
    baseLayers: {
      'Street Maps': this.streetMaps,
      'Wikimedia Maps': this.wMaps
    },
    overlays: {
      'Mt. Rainier Summit': this.summit,
      'Mt. Rainier Paradise Start': this.paradise,
      'Mt. Rainier Climb Route': this.route
    }
  };


  // Set the initial set of displayed layers (we could also use the leafletLayers input binding for this)
  options = {
    layers: [ this.streetMaps, this.route, this.summit, this.paradise ],
    zoom: 7,
    center: latLng([ 46.879966, -121.726909 ])
  };

  onMapReady(map: Map) {
    map.fitBounds(this.route.getBounds(), {
      padding: point(24, 24),
      maxZoom: 20,
      animate: true
    });
  }
}
